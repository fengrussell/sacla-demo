package demo

class Char {

}

object Char {
    def countLetter(str: String): Int = {
        for (l <- str) {
            if ((l >= 'A' && l <= 'Z') || (l >= 'a' && l <= 'z')) {
                println(l)
            }
        }
        0
    }

    /**
      * 计算字符串中英文字符的比例
      * @return
      */
    private def calcProportionENChars(query: String): Double = {
//        var molecular = 0;
//        for (l <- query) {
//            if ((l >= 'A' && l <= 'Z') || (l >= 'a' && l <= 'z')) {
//                molecular += 1
//            }
//        }
//        val molecular = query.count(c => Character.isAlphabetic(c.toInt))
//    val molecular = query.count(c => {if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) true else false})
//    val molecular = query.count(
//        c => {
//            println(c.toInt)
//            Character.isAlphabetic(c)}
//        )
//        println(molecular)
//        molecular * 1.0F / query.length()
        // 长度为0，则返回0.0
        if (query.length == 0) return 0.0
        val molecular = query.count(c => {if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) true else false})
        println(molecular)
        molecular * 1.0f / query.length()
    }

    def main(args: Array[String]): Unit = {
        val str = "12345abc中文1"
        println(calcProportionENChars(str))
//        val list = List(1, 2, 3, 4, 5, 6, 7)
//        println(list(0))
//        println(list(1))
////        val head = list.drop(1)
//        println(list.drop(1) :+ list(0))

//        println(order(list))
    }


    def order(list: List[Int]): List[Int] = {
        if (list.size > 1) {
            if (list(0) == 1) {
                return list.drop(1)
            }
        }

        list
    }
}
