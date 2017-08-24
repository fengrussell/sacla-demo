package akka.test1

import akka.actor.{ActorSystem, Props}

object Test1 {
    def main(args: Array[String]): Unit = {
        val system = ActorSystem("mySystem")
        val greeter = system.actorOf(Props[GreetingActor], name="greeter")

        greeter ! Greeting("Tom")
        println("i am not tom")
    }
}
