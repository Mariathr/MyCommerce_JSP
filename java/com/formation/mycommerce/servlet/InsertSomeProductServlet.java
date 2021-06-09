package com.formation.mycommerce.servlet;


import com.formation.mycommerce.app.bo.MyProduct;
import com.formation.mycommerce.app.dao.MyProductDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/auth/basicInsert")
public class InsertSomeProductServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyProduct product = new MyProduct();
        product.setName("Citron");
        product.setContent("Citron vert ou Pérou");
        product.setPrice(2.4f);
        MyProductDao.addProduct(product);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>My Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h5>Produit " + product.getName() + " </h5>");
        out.println("</body>");
        out.println("</html>");

    }
}
