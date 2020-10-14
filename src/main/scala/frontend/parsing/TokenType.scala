package frontend.parsing

object  TokenType extends Enumeration {
  type TokenType = Value
  val Int, Return, Lparen, Rparen, Lbrace, Rbrace, Semi = Value

  case class Integer(value: Int) extends TokenType.TokenType {
    override def id: Int = -1
  }
}