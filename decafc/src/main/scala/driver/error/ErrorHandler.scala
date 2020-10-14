package driver.error

import scala.collection.mutable

trait ErrorHandler {
  def submit(error: Error): Unit = errors += error

  def hasError: Boolean = errors.nonEmpty

  private val errors = new mutable.ArrayBuffer[Error]
}
