package org.evyatark.scraping.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class ReadyCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        final HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("ready");
        responseBuilder.up();
        return responseBuilder.build();
    }
}
