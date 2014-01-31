name := "PersianUtils"

version := "1.0"

organization := "com.bahmanm"

organizationHomepage := Some(url("http://BahmanM.com"))

description := "A collection of utilities for Scala/Java developers who are targeting Persian (Farsi) speaking users."

licenses += "Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")

publishMavenStyle := true

libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "2.3.6" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)
