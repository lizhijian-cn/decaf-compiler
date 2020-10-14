package frontend.parsing

import driver.Phase
import driver.error.Error
import frontend.parsing.TokenType.TokenType
import util.RichCharD.char2RichCharD

//
//class Lexer extends Phase[LazyList[Char], LazyList[Token]]("lexer") {
//  override def transform(in: LazyList[Char]): LazyList[Token] = in.headOption.map {
//    case ch if ch.isBlack => transform(in.dropWhile(_.isBlack))
//    case ch if ch.isLetter => lexIdentifierAndKeyword(in)
//    case ch if ch.isDigit => lexInteger(in)
//    case ch if ch.isOperator => lexOperator(in)
//    case _ => submit(new Error("unknown char"))
//      LazyList.empty
//  }.getOrElse(LazyList.empty)
//
//  private def lexIdentifierAndKeyword(in: LazyList[Char]): LazyList[Token] = {
//    val (res, rem) = in.span(_.isLetterOrDigit)
//    val token = res.mkString match {
//      case "FOR" => Token.For
//      case "IF" => Token.If
//      case "ELSE" => Token.Else
//      case identifier => Token.Identifier(identifier)
//    }
//    token #:: transform(rem)
//  }
//
//  private def lexInteger(in: LazyList[Char]): LazyList[Token] = {
//    val (res, rem) = in.span(_.isDigit)
//    Token.Integer(res.mkString.toInt) #:: transform(rem)
//  }
//
//  private def lexOperator(in: LazyList[Char]): LazyList[Token] = in match {
//    case '/' #:: '/' #:: _ => transform(in.dropWhile(_ != '\n'))
//    case '<' #:: '=' #:: rem => Token.Le #:: transform(rem)
//    case '>' #:: '=' #:: rem => Token.Ge #:: transform(rem)
//    case '=' #:: '=' #:: rem => Token.Eq #:: transform(rem)
//    case '!' #:: '=' #:: rem => Token.Ne #:: transform(rem)
//    case '&' #:: '&' #:: rem => Token.And #:: transform(rem)
//    case '|' #:: '|' #:: rem => Token.Or #:: transform(rem)
//    case op #:: rem =>
//      val token = op match {
//        case '+' => Token.Add
//        case '-' => Token.Sub
//        case '*' => Token.Mul
//        case '/' => Token.Div
//        case '%' => Token.Mod
//        case '<' => Token.Lt
//        case '>' => Token.Gt
//        case '=' => Token.Assign
//        case '!' => Token.Not
//        case ';' => Token.Semi
//        case ',' => Token.Comma
//        case '.' => Token.Dot
//      }
//      token #:: transform(rem)
//  }
//}
