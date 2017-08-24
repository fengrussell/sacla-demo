package akka.test1

import akka.actor.{Actor, ActorLogging}

case class Greeting(who: String)

class GreetingActor extends Actor with ActorLogging {
    override def receive = {
        case Greeting(who) => log.info("hello " + who)
    }
}
