package de

class SingleClass(var para_i: Int = 11) {
    var var_i: Int = _
    val val_i: Int = para_i
}

object SingleClass {
    def main(args: Array[String]): Unit = {
        val sc = new SingleClass(10)

        sc.var_i = 100
        println(s"var_i = ${sc.var_i}")
        println(s"val_i = ${sc.val_i}")
        println(s"para_i = ${sc.para_i}")
    }
}
