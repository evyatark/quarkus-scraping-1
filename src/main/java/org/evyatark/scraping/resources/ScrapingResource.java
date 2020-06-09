package org.evyatark.scraping.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@Path("/api/scraping")
public class ScrapingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/haaretz/today")
    @Produces(MediaType.TEXT_HTML)
    public Response today() {
        final URI uri = URI.create("https://evyatark.github.io/news/news/haaretz");

        return Response.temporaryRedirect(uri).build();
    }

    @GET
    @Path("/haaretz/this/week")
    @Produces(MediaType.TEXT_HTML)
    public Response currentWeek() {
        final URI uri = URI.create("https://evyatark.github.io/news/news/haaretz/archive/2020_06/index_20200601.html");

        return Response.temporaryRedirect(uri).build();
    }

    @GET
    @Path("/haaretz/collect")
    @Produces(MediaType.TEXT_HTML)
    public Response startCollectingThisDay() {
        // call Flask that will do same as this command:
        // cd ~/GitHub/PythonRoadmap/python-roadmap/ && docker run -p 5001:5000 -v /home/evyatar/GitHub/github-pages-hello-world/haaretz/:/out/ --rm --name scraping pythonroadmap/scraping:v01
        // and then rename index.html to index_20200609.html
        // then copy to news archive dir
        // change in file news/haaretz/index.html - add date of today with link to archive/2020_06/index_20200609.html
        // then push to GitHub news repo
        // in future: spawn a cleaner worker to zip and remove old months like 2020_05

        return Response.ok("collect articles for today... not implemented yet!").build();
    }
}

// see https://github.com/saharsh-samples/sample-quarkus-app/tree/master/src/main/java/org/saharsh/samples/quarkus/service on how to instantiate a specific implementation of an interface
