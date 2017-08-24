package akka.test2

import akka.actor.{Actor, ActorLogging}

class ServerActor extends Actor with ActorLogging {
    override def receive = {
        case Message(msg) => {
            log.info("server receive: " + msg)

        }
    }
}
