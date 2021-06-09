package com.formation.mycommerce.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/login.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String utilisateur = req.getParameter("username");

        HttpSession session = req.getSession();
        session.setAttribute("username", utilisateur);

        resp.sendRedirect( req.getContextPath() + "/auth/addProduct");
        //RequestDispatcher rd = req.getRequestDispatcher("/auth/addProduct");
        //rd.forward(req,resp);
    }
}
