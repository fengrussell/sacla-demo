package concurrent

import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.{Await, Future}
import scala.language.postfixOps
import scala.concurrent.duration._

import play.api.libs.concurrent.Execution.Implicits.defaultContext

case object AskNameMessage
case object TestMsg
case object ResMsg
case object InnerMsg

/**
  * 测试Actor调用future的并发问题
  * 1、Actor定义多个消息，一种是消息触发Counter++，另一个是消息触发Future，由Future触发Counter++
  */
class TestActor extends Actor {
    private var res = false
    var counter = 0

    def receive = {
        case AskNameMessage => // respond to the 'ask' request
            counter = counter + 1
            res = false
            sender ! "Fred"
            println("counter: " + counter)
        case TestMsg =>
            testFuture onSuccess {
                case msg =>
                    res = true
                    self ! InnerMsg
            }

        case InnerMsg =>
            counter = counter + 1
            println("counter: " + counter)

        case ResMsg =>
            println("counter: " + counter)

        case _ => println("that was unexpected")
    }

    def testFuture: Future[String] = {
//        Thread.sleep(100)
        Future(">>>> future")
    }

    def printCounter = {
        println("counter: " + counter)
    }
}

object AskDemo extends App {
    //create the system and actor
    val system = ActorSystem("AskDemoSystem")
    val myActor = system.actorOf(Props[TestActor], name="myActor")

    // (1) this is one way to "ask" another actor for information
    implicit val timeout = Timeout(5 seconds)

    for (i <- 1 to 300) {
        myActor ! TestMsg
        myActor ! AskNameMessage
    }


//    val future = myActor ? AskNameMessage
//    val result = Await.result(future, timeout.duration).asInstanceOf[String]
//    println(result)
//
//    // (2) a slightly different way to ask another actor for information
//    val future2: Future[String] = ask(myActor, AskNameMessage).mapTo[String]
//    val result2 = Await.result(future2, 1 second)
//    println(result2)

//    println(myActor.printCounter)

//    system.shutdown

    Thread.sleep(5000)

    val future = myActor ? ResMsg

    system.stop(myActor)

    System.exit(1)
}
