package de

case class CaseClass1() {
    val i: Int = 1
    def test: Unit = {} // 默认是public，但是scala没有public修饰符

    private def test_pri: Unit = {}
}

// 类的参数默认是val，下面是反编译的代码。不过appley/unapply方法只针对类的参数。
// JD-GUI反编译有些问题，para_str: String作为第二个参数，看不到private的定义。作为第一个参数就可以。如果发现没有，请不用怀疑。
/*
  private final String para_str;
  private final int i;
  private final int i_p;
  private String str;
 */
case class CaseClass2(para_i: Int, para_str: String) {
    val i: Int = 1
    private val i_p: Int = 2
    var str: String = _
}
