package metube.web.servlets;

import metube.domain.models.view.TubeDetailsViewModel;
import metube.services.TubeService;
import metube.web.WebConstants;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static metube.web.WebConstants.*;

@WebServlet(WebConstants.URL_TUBE_DETAILS)
public class TubeDetailsServlet extends HttpServlet {

    private final TubeService tubeService;

    @Inject
    public TubeDetailsServlet(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter(ATTRIBUTE_TITLE);
        TubeDetailsViewModel tube = this.tubeService.findByTitle(title);
        req.setAttribute(ATTRIBUTE_TUBE, tube);
        req.getRequestDispatcher(JSP_TUBE_DETAILS).forward(req, resp);
    }
}
