import sbt.Keys._
import sbt._

val appName = "http-verbs-test"

val compileDependencies = Seq(
  ws,
  json,
  "org.scalatest" %% "scalatest" % "2.2.4",
  "org.pegdown"   %  "pegdown"   % "1.5.0"
)

lazy val libraryName = Project(appName, file("."))
  .enablePlugins(SbtAutoBuildPlugin, SbtGitVersioning, SbtArtifactory)
  .settings(
    majorVersion := 1,
    makePublicallyAvailableOnBintray := true,
    scalaVersion := "2.11.7",
    libraryDependencies ++= compileDependencies,
    crossScalaVersions := Seq("2.11.7"),
    resolvers := Seq(
      Resolver.bintrayRepo("hmrc", "releases"),
      "typesafe-releases" at "http://repo.typesafe.com/typesafe/releases/"
    )
  )