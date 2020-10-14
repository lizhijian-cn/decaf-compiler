package driver

import driver.error.ErrorHandler

abstract class Phase[In, Out](name: String)
  extends Task[In, Out] with ErrorHandler {

  def transform(in: In): Out

  override def apply(in: In): Option[Out] = {
    Some(transform(in))
  }
}
