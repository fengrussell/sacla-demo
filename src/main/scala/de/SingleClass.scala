package de

//class SingleClass(var para_i: Int = 11) {
//    var var_i: Int = _
//    val val_i: Int = para_i
//    para_i = 1
//}

class SingleClass1(para_i: Int) {
    /*
      public int var_i()
      {
        return this.var_i;
      }

      public void var_i_$eq(int x$1)
      {
        this.var_i = x$1;
      }

      private int var_i = 1;
     */
    var var_i: Int = 1 // 不用声明private，默认就是private。scala没有public修饰符。不过使用private，对应的方法也是private，见下面的反编译代码。
    /*
      private int var_i()
      {
        return this.var_i;
      }

      private void var_i_$eq(int x$1)
      {
        this.var_i = x$1;
      }

      private int var_i = 1;
     */
//    private var var_i: Int = 1


    val val_i: Int = 2
}

class SingleClass2(var para_i: Int) { // var para_i，等同于在类里定义这样一个var变量。调用SingleClass2(10)，从反编译的结果，不是在构造函数里赋值，应该是直接para_i的方法
    var var_i: Int = 1
    val val_i: Int = 2
}

class SingleClass3(val para_i: Int) { // 和SingleClass2类似
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
    /* 反编译后的代码
      public SingleClass5(int para_i)
      {
        Predef..MODULE$.println("SingleClass5");
        test();
      }
     */
    println("SingleClass5")
    test
    // ------------------

    def test: Unit = {
        println("SingleClass5.test")
    }

    // 反编译后这个i没有val或var的修饰，但是这个i也是不可改变的
    def add(i: Int): Int = {
        i
    }

    def addClass(cls: SingleClass4): Unit = {
      cls.var_i = 10
//      cls = new SingleClass4(10) // 同add方法，不能再赋值，编译不过，提示：reassignment to val
    }

    // 使用private修饰符，就是声明函数为private，不加private就是public
    /* 反编译后的代码如下，很清楚了，不再解释
      private void privateMethod(int i)
      {
        Predef..MODULE$.println("private method");
      }

      public void noPirvateMethod(int i)
      {
        Predef..MODULE$.println("no private method");
      }
     */
    private def privateMethod(i: Int): Unit = {
        println("private method")
    }
    def noPirvateMethod(i: Int): Unit = {
        println("no private method")
    }
}

object SingleClass {
    def main(args: Array[String]): Unit = {
        val sc = new SingleClass2(10)
        println(sc.para_i)
        val sc4 = new SingleClass4(3, 4)
    }
}
