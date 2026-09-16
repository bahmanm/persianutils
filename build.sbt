import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

////////////////////////////////////////////////////////////////////////////////
// root aggregate
////////////////////////////////////////////////////////////////////////////////
lazy val root = project.in(file("."))
  .aggregate(persianutils.jvm, persianutils.js)
  .settings(
    publish / skip := true,
    scalaVersion := "2.13.18",
    crossScalaVersions := Seq("2.13.18", "3.3.8"),
    sourcesInBase := false,
    Compile / sources := Seq.empty,
    Test / sources := Seq.empty,
    Compile / unmanagedSourceDirectories := Seq.empty,
    Test / unmanagedSourceDirectories := Seq.empty
  )

////////////////////////////////////////////////////////////////////////////////
// cross-platform module (JVM & Scala.js)
////////////////////////////////////////////////////////////////////////////////
lazy val persianutils = crossProject(JVMPlatform, JSPlatform)
  .crossType(CrossType.Pure)
  .in(file("."))
  .settings(
    name := "persianutils",
    description := "A collection of utilities for Scala/Java developers who are targeting Persian (Farsi) speaking users.",
    homepage := Some(url("https://github.com/bahmanm/persianutils")),
    licenses += "Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"),
    organization := "com.bahmanm",
    organizationHomepage := Some(url("http://BahmanM.com")),

    scalaVersion := "2.13.18",
    crossScalaVersions := Seq("2.13.18", "3.3.8"),
    libraryDependencies ++= Seq(
      "org.scalameta" %%% "munit" % "1.3.6" % Test
    ),
    testFrameworks += new TestFramework("munit.Framework"),
    resolvers ++= Resolver.sonatypeOssRepos("snapshots"),
    resolvers ++= Resolver.sonatypeOssRepos("releases"),

    useGpg := true,
    pomIncludeRepository := { _ => false },
    versionScheme := Some("semver-spec"),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/bahmanm/persianutils"),
        "scm:git@github.com:bahmanm/persianutils.git"
      )
    ),
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
  )
  .jvmSettings(
    // JVM-specific settings
  )
  .jsSettings(
    libraryDependencies ++= Seq(
      "io.github.cquiroz" %%% "scala-java-time" % "2.7.0"
    )
  )

