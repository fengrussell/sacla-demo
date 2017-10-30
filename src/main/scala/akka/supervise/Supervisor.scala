package akka.supervise

import akka.actor.SupervisorStrategy.{Escalate, Restart, Resume, Stop}
import akka.actor.{Actor, ActorRef, ActorSystem, OneForOneStrategy, Props}
import akka.event.Logging

import scala.concurrent.duration._

case class Command(content: String, self: String)

class Supervisor extends Actor {
    //监管下属，根据下属抛出的异常进行相应的处理
    override val supervisorStrategy =
        OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1.minutes) {
            case _: ArithmeticException => Resume
            case _: NullPointerException => Restart
            case _: IllegalArgumentException => Stop
            case _: Exception => Escalate
        }

    var childIndex = 0

    override def receive: Receive = {
        case p: Props =>
            childIndex += 1
            sender() ! context.actorOf(p, s"child-${childIndex}")
    }
}

class Child extends Actor {
    val log = Logging(context.system, this)
    var state = 0
    def receive = {
        case ex: Exception => throw ex //抛出相应的异常
        case x: Int => state = x //改变自身状态
        case s: Command if s.content == "get" =>
            log.info(s"the ${s.self} state is ${state}")
            sender() ! state //返回自身状态
    }
}


