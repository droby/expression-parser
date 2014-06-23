package com.donroby.parsing

trait ExpressionSyntax {

  sealed abstract class Expression

  case class IntegerLiteral(i: Int) extends Expression
  case class Sum(e1: Expression, e2: Expression) extends Expression
  case class Product(e1: Expression, e2: Expression) extends Expression
}
