package io.treev.app

import cats.effect.{ExitCode, IO}
import Runtime.*
import io.treev.app.wiring.AppWiring

object Main extends App:

  (for
    appWiring <- AppWiring[F]()

    _ <- appWiring.web.server.use(_ => IO.never).as(ExitCode.Success)
  yield ()).unsafeRunSync()
