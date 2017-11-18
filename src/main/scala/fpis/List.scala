package fpis

import fpis.List.tail


sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
//    case Cons(head, tail) => head + sum(tail)
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ints: List[Double]): Double = ints match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def tail[A](xs: List[A]): List[A] = {
    case Nil => Nil
    case Cons(_, Nil) => Nil
    case Cons(head, tail) => tail
  }

  def setHead[A](head: A): List[A] = {
//    case Nil => Nil
    case Cons(x, xs) => Cons(head, xs)
    case _ => Nil
  }

  def drop[A](l: List[A], n: Int): List[A] = {
    if (n == 0) l
    else {
      case Nil => Nil
      case Cons(head, tail) => drop(tail, n-1)
    }
  }
}
