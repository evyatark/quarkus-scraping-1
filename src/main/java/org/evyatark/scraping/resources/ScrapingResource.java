package org.evyatark.scraping.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/scraping")
public class ScrapingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}

// see https://github.com/saharsh-samples/sample-quarkus-app/tree/master/src/main/java/org/saharsh/samples/quarkus/service on how to instantiate a specific implementation of an interface
