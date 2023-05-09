import sbt.*
import sbt.Keys.*

object Settings {

  val ScalacOptions: Seq[String] = Seq(
    "-deprecation",
    "-encoding", "UTF-8",
    "-explaintypes",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-source:future",
    "-unchecked",
    "-Werror",
    "-Wunused:implicits",
    "-Wunused:imports",
    "-Wunused:linted",
    "-Wunused:locals",
    "-Wunused:params",
    "-Wunused:privates"
  )

  val shared: Seq[Setting[?]] =
    Seq(
      ThisBuild / organization := "io.treev",
      ThisBuild / versionScheme := Some("early-semver"),

      scalaVersion := "3.3.0-RC5",
      scalacOptions ++= ScalacOptions,

      Compile / scalaSource := baseDirectory.value / "main",
      Compile / resourceDirectory := baseDirectory.value / "resources",

      Test / scalaSource := baseDirectory.value / "test",
      Test / resourceDirectory := baseDirectory.value / "test-resources",

      Compile / doc / sources := Seq.empty,
      Compile / packageDoc / publishArtifact := false
    )

}
