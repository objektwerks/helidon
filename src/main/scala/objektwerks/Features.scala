package objektwerks

import io.helidon.health.checks.HealthChecks
import io.helidon.webserver.observe.ObserveFeature
import io.helidon.webserver.observe.health.HealthObserver

object Features:
  def healthChecks(): ObserveFeature =
    ObserveFeature
      .create(
        HealthObserver
          .builder()
          .useSystemServices(false)
          .addCheck(HealthChecks.deadlockCheck())
          .addCheck(HealthChecks.diskSpaceCheck())
          .addCheck(HealthChecks.heapMemoryCheck())
          .details(true)
          .build()
      )

  def metrics(): ObserveFeature =
    ObserveFeature
      .builder()
      .config(config.get("server.features.observe"))
      .addObserver(MetricsObserver.create())
      .build()