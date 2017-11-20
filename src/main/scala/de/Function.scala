package de

class Function {
    var thunk1: Int = {
        5
    }

    def thunk2: Int = {
        5
    }


    /* 传名参数，没有()和有()的区别
      public void myByName1(Function0<Object> param)
      {
        Predef..MODULE$.println("start");
        Predef..MODULE$.println(BoxesRunTime.boxToBoolean(param.apply$mcZ$sp()));
        Predef..MODULE$.println("end");
      }

      public void myByName2(Function0<Object> param)
      {
        Predef..MODULE$.println("start");
        Predef..MODULE$.println(param);
        Predef..MODULE$.println("end");
      }
     */
    def myByName1(param: => Boolean): Unit = {
        println("start")
        println(param)      //println(param.apply())也可以
        println("end")
    }
    def myByName2(param: () => Boolean): Unit = {
        println("start")
        println(param)      //println(param.apply())也可以
        println("end")
    }
}

object Function {
    def main(args: Array[String]): Unit = {
        val func = new Function

        func.myByName1 {
            println("enter")
            7 > 9
        }

        func.myByName2 {() =>
            println("enter")
            7 > 9
        }
    }
}
