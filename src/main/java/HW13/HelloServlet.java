package HW13;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    private PrintWriter writer;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        writer = response.getWriter();
        writer.println("<h1>Hello, World</h1>");
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("        <head>\r\n")
                .append("            <title>Form input</title>\r\n")
                .append("        </head>\r\n")
                .append("        <body>\r\n")
                .append("            <form action=\"hello\" method=\"POST\">\r\n")
                .append("                Enter your name: \r\n")
                .append("                <input type=\"text\" name=\"user\" />\r\n")
                .append("                <input type=\"submit\" value=\"Submit\" />\r\n")
                .append("            </form>\r\n")
                .append("        </body>\r\n")
                .append("</html>\r\n");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // create HTML response
        writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("        <head>\r\n")
                .append("            <title>Welcome message</title>\r\n")
                .append("        </head>\r\n")
                .append("        <body>\r\n");
        if (user != null && !user.trim().isEmpty()) {
            writer.append("    Welcome " + user + ".\r\n");
        } else {
            writer.append("    You did not entered a name!\r\n");
        }
        writer.append("        </body>\r\n")
                .append("</html>\r\n");
    }
}
