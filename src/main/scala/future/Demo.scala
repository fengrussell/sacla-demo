package future


import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Demo {
    def getFuture: Future[List[Int]] = Future {
        val l = List[Int](1, 2, 3, 4, 5)
        Thread.sleep(1000)
        l
    }

    def getResult: Future[List[Int]] = {
        val f = getFuture

        println(">>>1")
        val m = f map {
            list =>
                println(">>>2")
                list.map {
                    r => r + 1
                }
        }

//        println(">>>>>>")
//        f onComplete {
//            case Success(posts) => println(posts)
//            case Failure(t) => println(t)
//        }

//        f onSuccess {
//            case r => println(r)
//        }
//        println(m)

        m map {
            list =>
                list map {
                    e => println(e)
                }
        }
//        for (e <- m) { println(">>: " + e)}

        println(">>>3")
        m

//        Thread.sleep(1500)
    }

    def main(args: Array[String]): Unit = {
//        Await.result(getResult, 2 seconds)
//        val value=Future {
//            Thread.sleep(2000)
//            1
//        }
//        getResult
        val v = Await.result(getResult, Duration.Inf)
//        println(v)
//        Thread.sleep(3000)
    }
}
