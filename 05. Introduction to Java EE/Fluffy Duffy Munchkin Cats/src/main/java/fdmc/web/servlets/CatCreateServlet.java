package fdmc.web.servlets;

import fdmc.domain.entities.Cat;
import fdmc.util.Reader;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cats/create")
public class CatCreateServlet extends HttpServlet {

    private static final String CREATE_HTML_PATH = "/views/cat-create.html";

    private final Reader reader;

    @Inject
    public CatCreateServlet(Reader reader) {
        this.reader = reader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String html = this.reader.readHtmlFile(CREATE_HTML_PATH);
        resp.getWriter().println(html);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cat cat = new Cat();
        cat.setName(req.getParameter("name"));
        cat.setBreed(req.getParameter("breed"));
        cat.setAge(Integer.parseInt(req.getParameter("age")));
        cat.setColor(req.getParameter("color"));

        Object list = this.getServletConfig().getServletContext().getAttribute("cats");
        if (list == null) {
            this.getServletConfig().getServletContext().setAttribute("cats", new HashMap<>());
        }

        Map<String, Cat> cats1 = (Map<String, Cat>) this.getServletConfig().getServletContext().getAttribute("cats");
        cats1.put(cat.getName(), cat);

//        req.getRequestDispatcher("/cats/profile?catName=" + cat.getName()).forward(req, resp);
        resp.sendRedirect("/cats/profile?catName=" + cat.getName());
    }
}
