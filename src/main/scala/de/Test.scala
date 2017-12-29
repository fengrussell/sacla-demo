package de

class Test {

}

object Test {
  def main(args: Array[String]): Unit = {
//    val l = List(1, 2, 3)
//    l.map(_ * 2).foreach(println(_))
//      l.map {
//          (e) => e * 2
//      }.foreach {
//          e => println(e)
//      }
      var o: Option[String] = None
      o = Some(" ")
      println(o.isEmpty)
      println(o.get.trim.isEmpty)
  }
}
