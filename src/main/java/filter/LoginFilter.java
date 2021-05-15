package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/*@WebFilter(
        urlPatterns = "/ValidationLoginServlet",
        filterName = "/LoginFilter",
        description = "Validate Login and Password"
        //dispatcherTypes = {DispatcherType.REQUEST}
)*/
@WebFilter(
        filterName="LoginFilter",
        urlPatterns={"/*/ValidationLoginServlet/*"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config)  {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("***** doFilter *****");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if( !validate(login, password) ) {
            PrintWriter out = response.getWriter();
            request.getRequestDispatcher("index.jsp").include(request, response);
            out.println("<br/><span style='color:red; display: flex; flex-direction: column; align-items: center'>Invalid login / password. Try again");
        } else {
            // request.setAttribute("password", password);

            chain.doFilter(request, response);
        }

    }

    private boolean validate(String login, String password) {
        if (login ==  null || password == null)
            return false;
        return login.equals("tom@gmail.com") && password.equals("jerry");
    }
}
