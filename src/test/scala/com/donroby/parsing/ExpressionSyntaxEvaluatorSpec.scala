package com.donroby.parsing

import com.donroby.parsing.ExpressionSyntaxEvaluator._
import org.scalatest.FlatSpec

class ExpressionSyntaxEvaluatorSpec  extends FlatSpec {

  "The expression syntax evaluator "  should "evaluate a literal" in {
    assert(evaluate(IntegerLiteral(42)) == 42)
  }

  it should "evaluate a sum of two literals" in {
    assert(evaluate(Sum(IntegerLiteral(2), IntegerLiteral(3))) == 5)
  }

  it should "evaluate a sum of two sum expressions" in {
    assert(
      evaluate(
        Sum(
          Sum(
            IntegerLiteral(2),
            IntegerLiteral(2)),
          Sum(
            IntegerLiteral(3),
            IntegerLiteral(1))
          )
      ) == 8)
  }

  it should "evaluate a product of two literals" in {
    assert(evaluate(Product(IntegerLiteral(2), IntegerLiteral(3))) == 6)
  }

}
