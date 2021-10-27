package tools.logging

import java.util.Date
import java.text.SimpleDateFormat

object Logger {
  val inputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
  private def fecha = inputFormat.format(new Date())

  def info(message: Any): Unit = System.out.println(s"$fecha [INFO] $message")
  def erro(message: Any): Unit = System.err.println(s"$fecha [ERRO] $message")
  def warn(message: Any): Unit =
    System.out.println(s"$fecha [WARN] $message")
}
