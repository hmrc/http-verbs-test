import sbt.Keys._
import sbt._

val libName = "http-verbs-test"

val compileDependencies = PlayCrossCompilation.dependencies(
  shared = Seq(
    "org.scalatest" %% "scalatest" % "3.0.5",
    "org.pegdown"   %  "pegdown"   % "1.6.0"
  ),
  play25 = Seq(
    "com.typesafe.play"              %% "play-ws"                % "2.5.19",
    "com.typesafe.play"              %% "play-json"              % "2.5.19",
    // force dependencies due to security flaws found in jackson-databind < 2.9.x using XRay
    "com.fasterxml.jackson.core"     % "jackson-core"            % "2.9.7",
    "com.fasterxml.jackson.core"     % "jackson-databind"        % "2.9.7",
    "com.fasterxml.jackson.core"     % "jackson-annotations"     % "2.9.7",
    "com.fasterxml.jackson.datatype" % "jackson-datatype-jdk8"   % "2.9.7",
    "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.9.7",
    // force dependencies due to security flaws found in xercesImpl 2.11.0
    // only applies to play 2.5 since it was removed from play 2.6
    // https://github.com/playframework/playframework/blob/master/documentation/manual/releases/release26/migration26/Migration26.md#xercesimpl-removal
    "xerces" % "xercesImpl" % "2.12.0"
  ),
  play26 = Seq(
    "com.typesafe.play"              %% "play-ws"                % "2.6.20",
    "com.typesafe.play"              %% "play-json"              % "2.6.13"
  )
)

lazy val libraryName = Project(libName, file("."))
  .enablePlugins(SbtAutoBuildPlugin, SbtGitVersioning, SbtArtifactory)
  .settings(
    majorVersion := 1,
    makePublicallyAvailableOnBintray := true,
    scalaVersion := "2.11.12",
    libraryDependencies ++= compileDependencies,
    crossScalaVersions := Seq("2.11.12", "2.12.8"),
    resolvers := Seq(
      Resolver.bintrayRepo("hmrc", "releases"),
      "typesafe-releases" at "http://repo.typesafe.com/typesafe/releases/"
    )
  ).settings(PlayCrossCompilation.playCrossCompilationSettings)
