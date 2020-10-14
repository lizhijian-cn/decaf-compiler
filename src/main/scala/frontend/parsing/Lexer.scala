package frontend.parsing

import driver.Phase
import util.RichCharD.char2RichCharD

class Lexer extends Phase[List[Char], List[Token]]("lexer") {
    override def transform(in: List[Char]): List[Token] = in.headOption.map {
      case ch if ch.isBlack => transform(in.dropWhile(_.isBlack))
      case ch if ch.isLetter => lexIdentifierAndKeyword(in)
      case ch if ch.isDigit => lexInteger(in)
      case ch if ch.isOperator => lexOperator(in)
//      case _ => submit(new Error("unknown char"))
//        List.empty
    }.getOrElse(List.empty)

    private def lexIdentifierAndKeyword(in: List[Char]): List[Token] = {
      val (res, rem) = in.span(_.isLetterOrDigit)
      val token = res.mkString match {
        case "int" => new Token(TokenType.Int)
//        case identifier => Token.Identifier(identifier)
      }
      token :: transform(rem)
    }

    private def lexInteger(in: List[Char]): List[Token] = {
      val (res, rem) = in.span(_.isDigit)
      new Token(TokenType.Integer(res.mkString.toInt)) :: transform(rem)
    }
    // TODO: number format exception & [0, 2^31-1)
    private def lexOperator(in: List[Char]): List[Token] = in match {
      case op :: rem =>
        val token = op match {
          case '(' => new Token(TokenType.Lparen)
          case ')' => new Token(TokenType.Rparen)
          case '{' => new Token(TokenType.Lbrace)
          case '}' => new Token(TokenType.Rbrace)
          case ';' => new Token(TokenType.Semi)
        }
        token :: transform(rem)
    }
}
