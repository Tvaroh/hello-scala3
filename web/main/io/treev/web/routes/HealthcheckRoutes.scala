package io.treev.web.routes

import cats.Monad
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

class HealthcheckRoutes[F[_]](using F: Monad[F])
  extends Http4sDsl[F]
    with Routes[F]:

  override val routes: HttpRoutes[F] =
    HttpRoutes.of:
      case GET -> Root / "healthcheck" =>
        Ok("Healthy")
