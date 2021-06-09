package com.formation.mycommerce.servlet;

import com.formation.mycommerce.app.bo.MyProduct;
import com.formation.mycommerce.app.dao.MyProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/auth/showProduct")
public class ShowProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nId = req.getParameter("id");
        Long lId =0l;
        try{
            lId = Long.parseLong(nId);
        }catch (Exception e){}
        MyProduct product = MyProductDao.findProductById(lId);

        req.setAttribute("product",product);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/showProduct.jsp");
        rd.forward(req,resp);
    }
}
