package metube.web.servlets.tube;

import metube.domain.models.binding.UploadTubeBindingModel;
import metube.services.TubeService;
import metube.web.WebConstants;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(WebConstants.UPLOAD_URL)
public class UploadServlet extends HttpServlet {

    private final TubeService tubeService;

    @Inject
    public UploadServlet(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(WebConstants.UPLOAD_VIEW_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String youtubeId = req.getParameter("youtube-link");
        String description = req.getParameter("description");

        UploadTubeBindingModel tube = new UploadTubeBindingModel();
        tube.setTitle(title);
        tube.setAuthor(author);
        tube.setYoutubeId(youtubeId);
        tube.setDescription(description);

        // TODO: 23.5.2019 г. find user and add
        this.tubeService.save(tube);
        resp.sendRedirect(WebConstants.HOME_URL);
    }
}
