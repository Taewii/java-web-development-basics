package chushka.web.servlets;

import chushka.domain.entities.enums.Type;
import chushka.domain.models.ProductServiceModel;
import chushka.services.ProductService;
import chushka.util.html.HtmlReader;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/create")
public class ProductCreateServlet extends HttpServlet {

    private static final String BASE_HTML = "/views/base.html";
    private static final String CREATE_PRODUCT_HTML_PATH = "/views/create-item.html";

    private HtmlReader htmlReader;
    private ProductService productService;

    @Inject
    public ProductCreateServlet(HtmlReader htmlReader, ProductService productService) {
        this.htmlReader = htmlReader;
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String baseHtml = this.htmlReader.readHtml(BASE_HTML);
        String template = this.htmlReader.readHtml(CREATE_PRODUCT_HTML_PATH);

        template = template.replace("{{options}}", Type.getTypesAsHtmlOptions());
        baseHtml = baseHtml.replace("{{body}}", template);

        resp.getWriter().println(baseHtml);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Type type = Type.getTypeFromName(req.getParameter("type"));

        ProductServiceModel product = new ProductServiceModel();
        product.setName(name);
        product.setDescription(description);
        product.setType(type);

        this.productService.save(product);

        resp.sendRedirect(String.format("/products/details?name=%s", product.getName()));
    }
}
