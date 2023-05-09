import sbt.*

object Deps {

  val CatsCore = "org.typelevel" %% "cats-core" % "2.9.0"
  val CatsEffect = "org.typelevel" %% "cats-effect" % "3.4.8"

  val Http4sDsl = "org.http4s" %% "http4s-dsl" % "1.0.0-M39"
  val Http4sServer = "org.http4s" %% "http4s-server" % "1.0.0-M39"
  val Http4sEmberServer = "org.http4s" %% "http4s-ember-server" % "1.0.0-M39"

  val Logback = "ch.qos.logback" %  "logback-classic" % "1.4.6"

}
