package akka.Robot

class Message {

}

trait Action {
    val message: String
    val time: Int
}

case class TurnonLight(time: Int) extends Action {
    val message = "Turn on the living room light"
}

case class BoilWater(time: Int) extends Action {
    val message = "Burn a pot of water"
}