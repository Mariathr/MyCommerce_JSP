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

@WebServlet(urlPatterns = "/auth/addProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/auth/addProduct.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyProduct nproduct = new MyProduct();
        nproduct.setName(req.getParameter("name"));
        nproduct.setContent(req.getParameter("Content"));
        String nprice = req.getParameter("Price");
        Float lprice =0f;
        try{
           lprice = Float.parseFloat(nprice);
        }catch (Exception e){}


        nproduct.setPrice(lprice);
        Long idProduct = MyProductDao.addProduct(nproduct);
        resp.sendRedirect( req.getContextPath() + "/auth/showProduct?id="+ idProduct);
    }


}
