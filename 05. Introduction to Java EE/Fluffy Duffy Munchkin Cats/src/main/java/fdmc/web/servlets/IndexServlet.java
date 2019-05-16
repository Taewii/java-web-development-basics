package fdmc.web.servlets;

import fdmc.util.Reader;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    private static final String HTML_INDEX_PATH = "/views/index.html";

    private final Reader reader;

    @Inject
    public IndexServlet(Reader reader) {
        this.reader = reader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String html = this.reader.readHtmlFile(HTML_INDEX_PATH);
        resp.getWriter().println(html);
    }
}
