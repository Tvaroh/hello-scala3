package io.treev.app

import cats.effect.IO
import cats.effect.unsafe.IORuntime

object Runtime:

  type F[A] = IO[A]

  implicit val runtime: IORuntime = cats.effect.unsafe.IORuntime.global
