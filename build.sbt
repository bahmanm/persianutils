name := "PersianUtils"
version := "2.0"
organization := "com.bahmanm"
organizationHomepage := Some(url("http://BahmanM.com"))
description := "A collection of utilities for Scala/Java developers who are targeting Persian (Farsi) speaking users."
licenses += "Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")
//
scalaVersion := "2.10.6"
crossScalaVersions := Seq("2.10.6", "2.11.11")
publishMavenStyle := true
resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)
libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "2.3.11" % "test"
)
scalacOptions in Test ++= Seq("-Yrangepos")


