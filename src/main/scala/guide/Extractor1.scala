package guide

/**
  * Created by russell on 2017/9/3.
  */

class Extractor1 {

}

trait User {
  def name: String
}

class FreeUser(val name: String) extends User

class PremiumUser(val name: String) extends User

object FreeUser {
  def unapply(user: FreeUser2): Option[String] = {
    Some(user.name)
  }
}

object PremiumUser {
  def unapply(user: PremiumUser2): Option[String] = {
    Some(user.name)
  }
}

case class User1(firstName: String, secondName: String, score: Int)

object Extractor1 {

//  def unapply(object: S): Option[T]


  def advance(xs: List[User1]): Int = {
    xs match {
      case User1(_, _, score1)::User1(_, _, score2)::_ => score1 - score2
      case _ => 0
    }
  }

  def main(args: Array[String]): Unit = {
//    println(FreeUser.unapply(new FreeUser("Daniel")).get)

    val user: User = new PremiumUser("Daniel")
    user match {
      case FreeUser(name) => "Hello " + name
      case PremiumUser(name) => println("Welcome back, dear " + name)
    }
  }
}
