package com.donroby.parsing

object ExpressionSyntaxEvaluator extends ExpressionSyntax {
  def evaluate(e: Expression): Int = e match {
    case IntegerLiteral(i) => i
    case _ => 0
  }
}
