package org.example;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        int[] arrResult =
                random.ints(10, 0, 20).toArray();
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");

        request.setAttribute("randomResult", arrResult);
        RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("demo.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
