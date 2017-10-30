package akka

import akka.actor._

class MyActor(param: Int) extends Actor {
  override def receive: Receive = {
    case _ => {
      // 2. create with ActorContext within a Actor
      context.actorOf(MyActor.props(param))
    }
  }
}

object MyActor {

  // Best Practice:
  // to declare what messages an Actor can receive in the companion object of the Actor
  case class Message1(content:String)
  case object Message2

  // Best Practice:
  // provide factory methods on the companion object of each Actor
  // which help keeping the creation of suitable Props as close to the actor definition as possible
  def props(param: Int): Props = {
    Props(new MyActor(param))
  }

  def main(args: Array[String]): Unit = {
    val props = Props(new MyActor(1))

    // 1. create top level Actor with ActorSystem
    // ActorSystem is a heavy object: create only one per application
    val system = ActorSystem("mySystem")
    val myActor1 = system.actorOf(props, "myactor")
  }
}

