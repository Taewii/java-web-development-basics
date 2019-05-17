package web.servlets;

import domain.entities.Product;
import services.ProductService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    private final ProductService productService;

    @Inject
    public HomeServlet(ProductService productService) {
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("works?");

        Product product = new Product();
        product.setName("name test");
        product.setDescription("description test");
        product.setType("Food");

        this.productService.add(product);
    }
}
