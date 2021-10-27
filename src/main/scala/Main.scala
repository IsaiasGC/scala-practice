import scala.io.StdIn.readLine
import scala.util.{Success, Failure}
import scala.async.Async.{async, await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._
import scala.language.postfixOps

import tools.logging.Logger.{info, erro}
import tools.Tools.{awaitResult, currentTime}

object Main extends App {
  val startTime = currentTime
  // a simulated web service
  def getStockPrice(stockSymbol: String): Future[Double] = async {
    print(s"-Igrese el Stock para $stockSymbol: ")
    val randomPrice: Double = readLine().toDouble
    randomPrice
  }
  def deltaTime(t0: Long) = currentTime - t0

  { // Main code block
    val result: Future[(Double, Double, Double)] = async {
      val aapl = await(getStockPrice("AAPL"))
      val amzn = await(getStockPrice("AMZN"))
      val goog = await(getStockPrice("GOOG"))

      (aapl, amzn, goog)
    }

    awaitResult(result, 100 seconds) match {
      case Success(x) => {
        info(s"In Success case, time delta: ${deltaTime(startTime)}")
        info(s"Stock prices are: $x")
      }
      case Failure(e) => {
        erro(s"Ocurrio un error: ${e.getMessage}")
      }
    }
  }
}
