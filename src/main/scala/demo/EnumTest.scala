package demo

class EnumTest {

}


object EnumTest extends Enumeration {
    type EnumTest = Value
    val One, Two, Three = Value
    val Four = Value(10, "four")

    def main(args: Array[String]): Unit = {
        println(EnumTest.withName("four").id)
        println(One.id)
        println(Two.id)

        println(EnumTest(1))
    }
}

//object EnumTest {
//    def main(args: Array[String]): Unit = {
//
//    }
//}
