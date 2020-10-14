package frontend.parsing

import driver.Phase
import frontend.tree.Prog

class Parser extends Phase[List[Token], Prog]("parser") {
  override def transform(in: List[Token]): Prog = ???
}
