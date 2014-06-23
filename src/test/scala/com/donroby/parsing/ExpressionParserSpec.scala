package com.donroby.parsing

import com.donroby.parsing.ExpressionParsers._
import org.scalatest.FlatSpec

class ExpressionParserSpec extends FlatSpec  {

  "The parser" should "parse an integer literal" in  {
    assert(parseExpression("42") == IntegerLiteral(42))
  }

  it should "parse a negative integer literal" in  {
    assert(parseExpression("-42") == IntegerLiteral(-42))
  }

  it should "parse a simple sum" in {
    assert(parseExpression("2 + 3") ==
      Sum(
        IntegerLiteral(2),
        IntegerLiteral(3)
      )
    )
  }

  it should "parse a simple product" in {
    assert(parseExpression("2 * 3") ==
      Product(
        IntegerLiteral(2),
        IntegerLiteral(3)
      )
    )
  }

  it should "parse a parenthesized sum" in {
    assert(parseExpression("(2 + 3)") ==
      Sum(
        IntegerLiteral(2),
        IntegerLiteral(3)
      )
    )
  }

  it should "parse a parenthesized product" in {
    assert(parseExpression("(2 * 3)") ==
      Product(
        IntegerLiteral(2),
        IntegerLiteral(3)
      )
    )
  }

  it should "parse a complex expression" in {
    assert(parseExpression("(2 * 3) * (4 + 5)") ==
      Product(
        Product(
          IntegerLiteral(2),
          IntegerLiteral(3)),
        Sum(
          IntegerLiteral(4),
          IntegerLiteral(5)
        )
      )
    )
  }

  it should "throw exception given incomplete input" in  {
    intercept[IllegalArgumentException] {
      parseExpression("2 +")
    }
  }

}
