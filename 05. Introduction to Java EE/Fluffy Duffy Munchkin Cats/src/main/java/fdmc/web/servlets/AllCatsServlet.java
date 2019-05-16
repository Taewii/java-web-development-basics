package fdmc.web.servlets;

import fdmc.domain.entities.Cat;
import fdmc.util.Reader;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/cats/all")
public class AllCatsServlet extends HttpServlet {

    private static final String ALL_CATS_HTML_PATH = "/views/all-cats.html";

    private final Reader reader;

    @Inject
    public AllCatsServlet(Reader reader) {
        this.reader = reader;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Cat> cats = (Map<String, Cat>) this.getServletConfig().getServletContext().getAttribute("cats");

        String html = this.reader.readHtmlFile(ALL_CATS_HTML_PATH);
        StringBuilder replacement = new StringBuilder();
        if (cats == null || cats.isEmpty()) {
            replacement = new StringBuilder("<p><strong>There are no cats. <a href=\"/cats/create\">Create some!</a></strong></p>");
        } else {
            for (Cat cat : cats.values()) {
                replacement.append(String.format("<a href=\"/cats/profile?catName=%s\">%s</a>", cat.getName(), cat.getName()));
                replacement.append("<br>").append(System.lineSeparator());
            }
        }

        html = html.replace("{{allCats}}", replacement.toString());
        resp.getWriter().println(html);
    }
}
