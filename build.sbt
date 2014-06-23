name := "expression-parser"

version := "1.0"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.0" % "test" withSources(),
//  "org.specs2" %% "specs2" % "2.3.12" % "test" withSources(),
//  "org.mockito" % "mockito-core" % "1.9.5"   withSources(),
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1" withSources()
)