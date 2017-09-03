package fpis.chapter3

/**
  * Created by russell on 2017/8/28.
  */
class MyList {

}

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = {
    ints match {
      case Nil => 0
      case Cons(x, xs) => x + sum(xs)
    }
  }

  def product(ds: List[Double]): Double = {
    ds match {
      case Nil => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(d, ds) => d * product(ds)
    }
  }

  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }

  def test(): Int = {
    val x = List(1, 2, 3, 4, 5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 4
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t) => h + sum(t)
      case _ => 101
    }

    x
  }

  def tail[A](l: List[A]): List[A] = {
    l match {
      case Nil => Nil
      case Cons(h, t) => t
    }
  }

  def sethead[A](l: List[A], a: A): List[A] = {
    l match {
      case Nil => Nil
      case Cons(h, t) => Cons(a, t)
    }
  }

  def print[A](l: List[A]): Unit = {
    l match {
      case Nil => println()
      case Cons(h, t) => {
        println(h)
        print(t)
      }
    }
  }

  def drop[A](l: List[A], n: Int): List[A] = {
    l match {
      case Nil => Nil
      case Cons(h, t) => if (n == 1) t else drop(t, n-1)
    }
  }

  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = {
    l match {
      case Nil => Nil
      case Cons(h, t) if f(h) => dropWhile(t, f)
      case _ => l
    }
  }

  def dropWhile2[A](as: List[A], f: A => Boolean): List[A] = {
    Nil
//    as match {
//      case Nil => Nil
//      case Cons(h, t) => {
//        if (f(h)) {
//          Cons(t, dropWhile2(t))
//        } else {
//          Nil
//        }
//      }
//
//      case _ => as
//    }
  }

  def init[A](l: List[A]): List[A] = {
    l match {
      case Nil => Nil
      case Cons(_, Nil) => Nil
      case Cons(h, t) => Cons(h, init(t))
    }
  }

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = {
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }
  }
}

object MyList {
  def main(args: Array[String]): Unit = {
//    println(List.test())
    val l = List(1, 2, 3, 4, 5)
//    List.print(l)
//    val t = List.tail(l)
//    List.print(t)
//    val s = List.sethead(l, 6)
//    List.print(s)
//    val d = List.drop(l, 6)
//    List.print(d)
//    val w = List.dropWhile(s, (n: Int)=>n > 3)
//    List.print(w)
    val i = List.init(l)
    List.print(i)
  }
}
