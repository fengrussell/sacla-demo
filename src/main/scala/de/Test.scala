package de

class Test {
    def method1: Unit = {} // 没有参数，编译后和method2一样。但是调用时不能加()，编译不过。

    def method2(): Unit = {}

    var add1 = (x: Int, y: Int) => x + y

    def add2 = (x: Int, y: Int) => x + y
}

object Test {
  def main(args: Array[String]): Unit = {
      val test = new Test
      test.method1
      test.method2
      test.method2()
  }
}
