package de

//class SingleClass(var para_i: Int = 11) {
//    var var_i: Int = _
//    val val_i: Int = para_i
//    para_i = 1
//}

class SingleClass1(para_i: Int) {
    var var_i: Int = 1 // 不用声明private，默认就是private。scala没有public修饰符
    val val_i: Int = 2
}

class SingleClass2(var para_i: Int) { // var para_i，等同于在类里定义这样一个var变量。调用SingleClass2(10)，从反编译的结果，不是在构造函数里赋值，应该是直接para_i的方法
    var var_i: Int = 1
    val val_i: Int = 2
}

class SingleClass3(val para_i: Int) {
    var var_i: Int = 1
    val val_i: Int = 2
}

class SingleClass4(para_i: Int) {
    var var_i: Int = 1
    val val_i: Int = 2

    // 定义一个新的构造函数
    def this(i1: Int, i2: Int) {
        this(i1) // 必须调用默认this构造函数，如果没有定义，就是this()
        // ......
    }
}

class SingleClass5(para_i: Int) {
    // 这些内容都在构造函数调用
    println("SingleClass5")
    test
    // ------------------

    def test: Unit = {
        println("SingleClass5.test")
    }
}

object SingleClass {
    def main(args: Array[String]): Unit = {
        val sc = new SingleClass2(10)
        println(sc.para_i)
    }
}
