package chushka.web.servlets;

import chushka.domain.models.ProductViewModel;
import chushka.services.ProductService;
import chushka.util.html.HtmlReader;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/details")
public class ProductDetailsServlet extends HttpServlet {

    private static final String BASE_HTML = "/views/base.html";
    private static final String PRODUCT_DETAILS_HTML_PATH = "/views/product-details.html";

    private HtmlReader htmlReader;
    private ProductService productService;

    @Inject
    public ProductDetailsServlet(HtmlReader htmlReader, ProductService productService) {
        this.htmlReader = htmlReader;
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");

        String baseHtml = this.htmlReader.readHtml(BASE_HTML);
        String template = this.htmlReader.readHtml(PRODUCT_DETAILS_HTML_PATH);

        ProductViewModel product = this.productService.findByName(name);

        template = template
                .replace("{{name}}", product.getName())
                .replace("{{description}}", product.getDescription())
                .replace("{{type}}", product.getType().getName());
        baseHtml = baseHtml
                .replace("{{body}}", template);

        resp.getWriter().println(baseHtml);
    }
}
