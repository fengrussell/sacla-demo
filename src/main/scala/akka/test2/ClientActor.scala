package akka.test2

import akka.actor.{Actor, ActorLogging, ActorRef}

case class Message(msg: String)

class ClientActor(listener: ActorRef) extends Actor with ActorLogging {
    override def receive = {
        case Message(msg) => {
            log.info("client receive: " + msg)
            listener ! Message("hello")
        }
    }
}
