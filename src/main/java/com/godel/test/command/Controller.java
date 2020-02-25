package com.godel.test.command;

import com.godel.test.connetion.ConnectionPool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * controller получает запрос, анализирует его и вызывает соответствующий метод
 *
 * @author Shpakova A.
 */


public class Controller extends HttpServlet {
        @Override
        public void init() throws ServletException {
            ConnectionPool connectionPool=ConnectionPool.INSTANCE;
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");

           processRequest(request,response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            processRequest(request,response);
        }

        private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            Command command = ActionFactory.defineCommand(action);
            command.execute(request);

            if (action != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            } else {
                request.getSession().setAttribute("nullPage", "Page not found");
                response.sendRedirect(request.getContextPath() +PathForJsp.ERROR.getPath());
            }
        }

        @Override
        public void destroy() {
            ConnectionPool.INSTANCE.destroyPool();
        }
}
