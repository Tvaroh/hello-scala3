name := "treevio"

Settings.shared

val utilEffect =
  project.in(file("util/effect"))
    .settings(Settings.shared)
    .settings(
      name := "util-effect",
      libraryDependencies ++= Seq(
        Deps.CatsCore, Deps.CatsEffect
      )
    )

val web =
  project.in(file("web"))
    .dependsOn(utilEffect)
    .settings(Settings.shared)
    .settings(
      name := "web",
      libraryDependencies ++= Seq(
        Deps.Http4sDsl, Deps.Http4sServer
      )
    )

val app =
  project.in(file("app"))
    .dependsOn(web)
    .settings(Settings.shared)
    .settings(
      name := "app",
      libraryDependencies ++= Seq(
        Deps.Http4sEmberServer,
        Deps.Logback % Runtime
      )
    )
