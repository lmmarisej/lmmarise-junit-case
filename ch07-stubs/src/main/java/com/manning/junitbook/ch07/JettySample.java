package com.manning.junitbook.ch07;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;

/**
 * A class that demonstrates how to create a sample Jetty embedded server.
 *
 * @version $Id$
 */
public class JettySample {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        Context root = new Context(server, "/");
        root.setResourceBase("/Users/lmmarise.j/develop/java_web_project_list/lmmarise-junit-case/ch07-stubs/pom.xml");
        root.setHandler(new ResourceHandler());

        server.setStopAtShutdown(true);
        server.start();
    }
}
