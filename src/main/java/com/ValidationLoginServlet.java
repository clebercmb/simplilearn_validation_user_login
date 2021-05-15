package com;

import to.Login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/*@WebServlet(name = "ValidationLoginServlet", value = "/ValidationLoginServlet")*/
@WebServlet(
        name = "ValidationLoginServlet",
        urlPatterns = {"/ValidationLoginServlet"})
public class ValidationLoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("****ValidationLoginServlet*****");
        Login login = (Login) request.getAttribute("login");

        PrintWriter out = response.getWriter();

        out.println("<div>");
        out.println("<h1>Hello "+ login.getLogin() +" you had a successful login!</h1>");
        out.println("</div>");
        System.out.println(">> login="+login);

    }
}
