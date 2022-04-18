///usr/bin/env jbang "$0" "$@" ; exit $?
// Update the Quarkus version to what you want here or run jbang with
// `-Dquarkus.version=<version>` to override it.
//DEPS io.quarkus:quarkus-bom:${quarkus.version:2.8.0.Final}@pom
//DEPS io.quarkiverse.renarde:quarkus-renarde:1.0.0

//JAVAC_OPTIONS -parameters

//webjars
//DEPS io.quarkus:quarkus-webjars-locator
//DEPS org.webjars.npm:htmx.org:1.7.0

//TODO: add globbing support in //FILES https://github.com/jbangdev/jbang/issues/1338
//FILES templates/Main/index.qute.html=Main/index.qute.html

package rest;

import javax.ws.rs.Path;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.quarkiverse.renarde.Controller;

public class Main extends Controller {

    @CheckedTemplate
    static class Templates {
        public static native TemplateInstance index();
    }

    @Path("/")
    public TemplateInstance index() {
        return Templates.index();
    }
}