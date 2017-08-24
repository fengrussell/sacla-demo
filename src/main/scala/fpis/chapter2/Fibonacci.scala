package fpis.chapter2

class Fibonacci {

}

object Fibonacci {

    /**
      * 如果是递归的方式，通常就是f(n) = f(n-1) + f(n-2)
      * scala尾递归会转化为while的方式（注意加上@annotation.tailrec，如果不符合编译过不去）
      * 实现思路：不是从n-1开始，而是从0,1开始不断的计算。每一次都是用前一次的acct1、acct2来计算后面的值，上一次acct2（其实就是n-2）就变成了acct1，儿acct2就是上一次acct1和acct2的和。依次类推
      * @param n
      * @return
      */
    def fib(n: Int): Int = {
        @annotation.tailrec
        def go(n: Int, acct1: Int, acct2: Int): Int = {
            if (n <= 2) acct2
            else go(n-1, acct2, acct1+acct2)
        }

        go(n, 0, 1)
    }

    def main(args: Array[String]): Unit = {
        val n = fib(5)
        println(s"fib(5)=${n}")
    }
}
