package io.treev.app.wiring

import cats.effect.{Async, Resource}
import cats.syntax.all.*
import com.comcast.ip4s.{ipv4, port}
import io.treev.web.routes.HealthcheckRoutes
import org.http4s.HttpRoutes
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.{Router, Server}

trait WebWiring[F[_]]:

  val server: Resource[F, Server]

object WebWiring:

  def apply[F[_]]()(using F: Async[F]): F[WebWiring[F]] =
    val healthcheckRoutes = new HealthcheckRoutes[F]

    val routes =
      Seq(healthcheckRoutes)
        .map(_.routes)
        .reduce(_ <+> _)

    F.pure:
      new WebWiring[F]:
        override val server: Resource[F, Server] =
          EmberServerBuilder.default[F]
            .withHost(ipv4"0.0.0.0")
            .withPort(port"10000")
            .withHttpApp(Router("/api" -> routes).orNotFound)
            .build
