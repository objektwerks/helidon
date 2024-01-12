package objektwerks

import io.helidon.health.checks.HealthChecks
import io.helidon.webserver.observe.ObserveFeature
import io.helidon.webserver.observe.health.HealthObserver
import io.helidon.webserver.observe.metrics.MetricsObserver

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
      .config(Conf.metrics)
      .addObserver(MetricsObserver.create())
      .build()