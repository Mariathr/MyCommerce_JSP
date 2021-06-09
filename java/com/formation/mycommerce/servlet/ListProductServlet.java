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
import java.util.List;
import java.util.function.Consumer;
@WebServlet(urlPatterns = "/auth/listProduct")
public class ListProductServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MyProduct> nlistproduct =  MyProductDao.getAllProducts();
        req.setAttribute("listproduct",nlistproduct);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/listProduct.jsp");
        rd.forward(req,resp);

    }
}
