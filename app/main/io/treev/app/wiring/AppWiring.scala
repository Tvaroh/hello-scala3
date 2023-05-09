package io.treev.app.wiring

import cats.effect.Async
import cats.syntax.all.*

trait AppWiring[F[_]]:

  val web: WebWiring[F]

object AppWiring:

  def apply[F[_]]()(using F: Async[F]): F[AppWiring[F]] =
    for
      webWiring <- WebWiring()
    yield
      new AppWiring[F]:
        override val web: WebWiring[F] = webWiring
