package com.ari.websocketer.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.jboss.weld.environment.servlet.Listener;

/**
 * The simplest possible Jetty server.
 */
public class SimplestServer
{
    public static void main( String[] args ) throws Exception
    {
        Server server = new Server(8080);

        //add one webcontext
        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setResourceBase("src/main/resources");
        server.setHandler(context);
        context.addServlet(HelloWorldServlet.class, "/*");

        //here we add listener to get CDI
        context.addEventListener(new Listener());

        //start server and join the thread
        server.start();
       // server.dumpStdErr();
        server.join();
    }
}
