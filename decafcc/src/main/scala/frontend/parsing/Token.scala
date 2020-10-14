package frontend.parsing

object Token extends Enumeration {
  type Token = Value
  val Bool, True, False,
  Void, Int, String, If, Else, For, While, Break,
  Class, Extends, New, Null, This, Static, Instanceof,
  Print, ReadInteger, ReadLine = Value

  val Assign, Not, Add, Sub, Mul, Div, Mod, And, Or,
  Eq, Ne, Le, Lt, Ge, Gt,
  Dot, Comma, Semi,
  Lparen, Rparen, Lbrack, Rbrack, Lbrace, Rbrace = Value

  case class Identifier(name: String) extends Token.Token {
    override def id: Int = -1
  }

  case class Integer(value: Int) extends Token.Token {
    override def id: Int = -2
  }

}