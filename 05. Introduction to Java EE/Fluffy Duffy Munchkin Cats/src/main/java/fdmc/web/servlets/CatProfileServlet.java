package fdmc.web.servlets;

import fdmc.domain.entities.Cat;
import fdmc.util.Reader;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/cats/profile")
public class CatProfileServlet extends HttpServlet {

    private static final String NOT_FOUND_HTML_PATH = "/views/cat-not-found.html";
    private static final String CAT_PROFILE_HTML = "/views/cat-profile.html";

    private final Reader reader;

    @Inject
    public CatProfileServlet(Reader reader) {
        this.reader = reader;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("catName");
        Cat cat = ((Map<String, Cat>) this.getServletConfig()
                .getServletContext()
                .getAttribute("cats"))
                .getOrDefault(name, null);

        PrintWriter writer = resp.getWriter();
        String html;
        if (cat == null) {
            html = this.reader.readHtmlFile(NOT_FOUND_HTML_PATH).replace("{{name}}", name);
        } else {
            html = this.reader.readHtmlFile(CAT_PROFILE_HTML)
                    .replace("{{name}}", cat.getName())
                    .replace("{{breed}}", cat.getBreed())
                    .replace("{{age}}", String.valueOf(cat.getAge()))
                    .replace("{{color}}", cat.getColor());
        }
        writer.println(html);
    }
}
