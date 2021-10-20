package tools.sorting

object Sorter{
    def quickSort(list: List[Int]): List[Int] = list match {
        case Nil => Nil
        case x :: xs =>
        (quickSort(xs.filter(_ <= x) :+ x) ++ quickSort(xs.filter(_ > x)))
  }
}