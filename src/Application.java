///usr/bin/env jbang "$0" "$@" ; exit $?
// Update the Quarkus version to what you want here or run jbang with
// `-Dquarkus.version=<version>` to override it.
//DEPS io.quarkus:quarkus-bom:${quarkus.version:2.8.0.Final}@pom
//DEPS io.quarkiverse.renarde:quarkus-renarde:1.0.0

//JAVAC_OPTIONS -parameters

//webjars
//DEPS org.webjars:bootstrap:5.1.3
//DEPS org.webjars.npm:bootstrap-icons:1.7.0
//DEPS io.quarkus:quarkus-webjars-locator

//FILES templates/Application/index.html=../resources/Application/index.html

package rest;

import javax.ws.rs.Path;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.quarkiverse.renarde.Controller;

public class Application extends Controller {

    @CheckedTemplate
    static class Templates {
        public static native TemplateInstance index();
    }

    @Path("/")
    public TemplateInstance index() {
        return Templates.index();
    }
}