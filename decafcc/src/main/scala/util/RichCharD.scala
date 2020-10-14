package util

class RichCharD(ch: Char) {
  def isBlack: Boolean = Array(' ', '\t', '\r', '\n').contains(ch)

  def isOperator: Boolean = Array('+', '-', '*', '/').contains(ch)
}

object RichCharD {
  implicit def char2RichCharD(ch: Char) = new RichCharD(ch)
}
