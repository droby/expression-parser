package com.donroby.parsing

import com.donroby.parsing.ExpressionSyntaxEvaluator._
import org.scalatest.FlatSpec

class ExpressionSyntaxEvaluatorSpec  extends FlatSpec {

  "The expression syntax evaluator "  should "evaluate a literal" in {
    assert(evaluate(IntegerLiteral(42)) == 42)
  }

}
