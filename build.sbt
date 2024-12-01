////////////////////////////////////////////////////////////////////////////////
// artifact
////////////////////////////////////////////////////////////////////////////////
name := "persianutils"
description := "A collection of utilities for Scala/Java developers who are targeting Persian (Farsi) speaking users."
version := "5.0"
homepage := Some(url("https://github.com/bahmanm/persianutils"))
licenses += "Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")
organization := "com.bahmanm"
organizationHomepage := Some(url("http://BahmanM.com"))

////////////////////////////////////////////////////////////////////////////////
// build
////////////////////////////////////////////////////////////////////////////////
scalaVersion := "2.13.15"
libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "4.20.9" % "test"
)
resolvers ++= Resolver.sonatypeOssRepos("snapshots")
resolvers ++= Resolver.sonatypeOssRepos("releases")
scalacOptions in Test ++= Seq("-Yrangepos")
crossScalaVersions := Seq("2.12.18", "2.13.11", "3.3.0")

////////////////////////////////////////////////////////////////////////////////
// sonatype and maven central
////////////////////////////////////////////////////////////////////////////////
useGpg := true
pomIncludeRepository := { _ => false }
versionScheme := Some("semver-spec")
scmInfo := Some(
  ScmInfo(
    url("https://github.com/bahmanm/persianutils"),
    "scm:git@github.com:bahmanm/persianutils.git"
  )
)
developers := List(
  Developer(
    id    = "bahmanm",
    name  = "Bahman Movaqar",
    email = "Bahman@BahmanM.com",
    url   = url("https://BahmanM.com/")
  ),
  Developer(
    id    = "amirkarimi",
    name  = "Amir Karimi",
    email = "a.karimi.k@gmail.com",
    url   = url("https://amirkarimi.me/")
  ),
  Developer(
    id    = "KeivanAbdi",
    name  = "Keivan Abdi",
    email = "keivan.a.khorsand@gmail.com",
    url   = url("https://keivanabdi.com/")
  )
)
