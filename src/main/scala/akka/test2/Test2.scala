package akka.test2

import akka.actor.{ActorSystem, Props}

object Test2 {
    def main(args: Array[String]): Unit = {
        val system = ActorSystem("mySystem")

        val serverActor = system.actorOf(Props[ServerActor])
        val clientActor = system.actorOf(Props(classOf[ClientActor], serverActor))

        clientActor ! Message("123")
        serverActor ! Message("456")
    }
}
