package akka.Robot

import akka.actor.{Actor, ActorSystem, Props}
import akka.event.Logging

class RobotActor extends Actor {
    val log = Logging(context.system, this)

    def receive: Receive = {
        case t: TurnonLight => log.info(s"${t.message} after ${t.time} hour")
        case b: BoilWater => log.info(s"${b.message} after ${b.time} hour")
        case _ => log.info("I can not handle this message")
    }
}

object RobotActor {
    def main(args: Array[String]): Unit = {
        val actorSystem = ActorSystem("robot-system")
        val robotActor = actorSystem.actorOf(Props(new RobotActor()), "robotActor")

        robotActor ! TurnonLight(1)
        robotActor ! BoilWater(2)
        robotActor ! "who are you"

        Thread.sleep(1000)

        actorSystem.terminate()
    }
}
