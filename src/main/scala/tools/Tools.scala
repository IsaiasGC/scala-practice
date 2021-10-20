package tools

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Awaitable}
import scala.util.{Try, Success, Failure}

object Tools {
  def currentTime = System.currentTimeMillis()
  def sleep(time: Long): Unit = Thread.sleep(time)
  def awaitResult[T](future: Awaitable[T], maxTime: Duration): Try[T] = Try {
    Await.result(future, maxTime)
  }
}
