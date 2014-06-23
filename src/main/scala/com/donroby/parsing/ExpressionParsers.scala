package com.donroby.parsing

import scala.util.parsing.combinator.RegexParsers
import scala.util.parsing.input.CharSequenceReader

trait ExpressionParsers extends RegexParsers with ExpressionSyntax {

  def integer:Parser[IntegerLiteral] = {
    """-?\d+""".r ^^ {
      s => new IntegerLiteral(s.toInt)
    }
  }

  def sum:Parser[Sum] = operand ~ "+" ~ operand ^^ {
    case (x ~ "+" ~ y) => Sum(x, y)
  }

  def product:Parser[Product] = operand ~ "*" ~ operand ^^ {
    case (x ~ "*" ~ y) => Product(x, y)
  }

  def parenthesizedExpression = "(" ~> expression <~ ")"

  def operand = (integer | parenthesizedExpression)

  def expression:Parser[Expression] = ( sum | product | integer | parenthesizedExpression )

}

object ExpressionParsers extends ExpressionParsers {

  def parseExpression(s: CharSequence): Expression = {
    parseExpression(new CharSequenceReader(s))
  }

  def parseExpression(input: CharSequenceReader): ExpressionParsers.Expression = {
    parsePhrase(input) match {
      case Success(t, _) => t
      case NoSuccess(msg, next) => throw new IllegalArgumentException(
        "Could not parse '" + input + "' near '" + next.pos.longString + ": " + msg)
    }
  }

  def parsePhrase(input: CharSequenceReader): ParseResult[Expression] = {
    phrase(expression)(input)
  }
}
