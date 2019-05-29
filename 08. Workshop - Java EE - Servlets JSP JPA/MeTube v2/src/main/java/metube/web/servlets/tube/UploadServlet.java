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
        UploadTubeBindingModel tube = (UploadTubeBindingModel) req.getAttribute("model");

        this.tubeService.upload(tube);
        resp.sendRedirect(WebConstants.HOME_URL);
    }
}
