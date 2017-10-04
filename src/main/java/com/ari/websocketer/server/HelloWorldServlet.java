package com.ari.websocketer.server;

import com.ari.websocketer.greeter.Greeter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloWorldServlet extends HttpServlet {
    private long helloCount = 0;
    @Inject
    private Greeter greeter;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("request URI=" + req.getRequestURI());
        resp.setContentType("text/plain");
        resp.getWriter().append("helloCount(before)="+helloCount+"</br>");
        helloCount++;

        resp.getWriter().append("helloCount="+helloCount); // + manager);

        if(greeter!=null){
            resp.getWriter().append(" "+greeter.sayGreeting());
        }
        resp.getWriter().close();
    }
}
