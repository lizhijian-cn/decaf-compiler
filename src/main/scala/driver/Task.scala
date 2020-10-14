package driver

trait Task[-A, +B] extends Function[A, Option[B]] {
  def ->[C](g: Task[B, C]): Task[A, C] = x => this (x) flatMap g
}
