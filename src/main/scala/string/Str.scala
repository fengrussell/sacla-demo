package string

object Str {
    def main(args: Array[String]): Unit = {
        val str1 = ""
        val str2 = "FT HOW LOW"
        val str3 = "AVE MARIA NO播放儿歌"

        // exists比map().getOrElse更好，编译器会给提示
        if (str1.headOption.exists(c=>if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) true else false)) {
            println("str： " + str1)
        }

        if (str2.headOption.exists(c=>if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) true else false)) {
            println("str： " + str2)
        }

        if (str3.headOption.exists(c=>if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) true else false)) {
            println("str： " + str3)
        }
    }
}
