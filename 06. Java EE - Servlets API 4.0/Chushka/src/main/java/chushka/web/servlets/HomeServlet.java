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
import java.util.List;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    private static final String BASE_HTML = "/views/base.html";
    private static final String HOME_HTML_PATH = "/views/home.html";

    private final HtmlReader htmlReader;
    private final ProductService productService;

    @Inject
    public HomeServlet(HtmlReader htmlReader, ProductService productService) {
        this.htmlReader = htmlReader;
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String baseHtml = this.htmlReader.readHtml(BASE_HTML);
        String template = this.htmlReader.readHtml(HOME_HTML_PATH);
        baseHtml = baseHtml.replace("{{body}}", template);

        List<ProductViewModel> products = this.productService.findAll();
        String items = parseToListTemplate(products);

        baseHtml = baseHtml.replace("{{items}}", items);
        resp.getWriter().println(baseHtml);
    }

    private String parseToListTemplate(List<ProductViewModel> products) {
        StringBuilder sb = new StringBuilder();

        for (ProductViewModel product : products) {
            String li = String.format("<li><a href=\"products/details?name=%s\">%s</a></li>",
                    product.getName(),
                    product.getName());
            sb.append(li).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
