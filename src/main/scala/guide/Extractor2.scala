package guide

/**
  * Created by russell on 2017/9/3.
  * https://windor.gitbooks.io/beginners-guide-to-scala/content/chp1-extractors.html
  */

class Extractor2 {

}

trait User2 {
  def name: String
  def score: Int
}

class FreeUser2(val name: String,
                val score: Int,
                val upgradeProbability: Double) extends User2

class PremiumUser2(val name: String, val score: Int) extends User2

object FreeUser2 {
  def unapply(user: FreeUser2): Option[(String, Int, Double)] = {
    Some((user.name, user.score, user.upgradeProbability))
  }
}

object PremiumUser2 {
  def unapply(user: PremiumUser2): Option[(String, Int)] = {
    Some((user.name, user.score))
  }
}

object Extractor2 {

  def main(args: Array[String]): Unit = {
//    println(FreeUser.unapply(new FreeUser("Daniel")).get)

    val user: User2 = new FreeUser2("Daniel", 3000, 0.7d)
    user match {
      case FreeUser2(name, _, p) =>
        if (p > 0.75) println(s"${name}, what can we do for you today?")
        else println(s"Hello $name")
      case PremiumUser2(name, _) =>
        println(s"Welcome back, dear ${name}")
    }
  }
}
