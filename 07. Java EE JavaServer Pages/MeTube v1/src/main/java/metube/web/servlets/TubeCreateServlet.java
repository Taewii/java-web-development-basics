package metube.web.servlets;

import metube.domain.models.binding.TubeBindingModel;
import metube.services.TubeService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tube/create")
public class TubeCreateServlet extends HttpServlet {

    private final TubeService tubeService;

    @Inject
    public TubeCreateServlet(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/templates/tube-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        TubeBindingModel tube = new TubeBindingModel();

        tube.setTitle(req.getParameter("title"));
        tube.setDescription(req.getParameter("description"));
        tube.setYoutubeLink(req.getParameter("youtube-link"));
        tube.setUploader(req.getParameter("uploader"));

        this.tubeService.save(tube);
        resp.sendRedirect(String.format("/tube/details?title=%s", tube.getTitle()));
    }
}
