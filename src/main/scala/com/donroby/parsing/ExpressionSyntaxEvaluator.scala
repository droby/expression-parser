package com.donroby.parsing

object ExpressionSyntaxEvaluator extends ExpressionSyntax {
  def evaluate(e: Expression): Int = e match {
    case IntegerLiteral(i) => i
    case Sum(e1, e2) => evaluate(e1) + evaluate(e2)
    case _ => 0
  }
}
