name := "PersianUtils"

version := "2.0-SNAPSHOT"

crossScalaVersions := Seq("2.10.0", "2.11.2", "2.11.6")

organization := "com.bahmanm"

organizationHomepage := Some(url("http://BahmanM.com"))

description := "A collection of utilities for Scala/Java developers who are targeting Persian (Farsi) speaking users."

licenses += "Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")

publishMavenStyle := true

libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "2.3.11" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)
