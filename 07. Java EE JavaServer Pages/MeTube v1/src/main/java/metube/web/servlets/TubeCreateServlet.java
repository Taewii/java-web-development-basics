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

import static metube.web.WebConstants.*;

@WebServlet(URL_TUBE_CREATE)
public class TubeCreateServlet extends HttpServlet {

    private final TubeService tubeService;

    @Inject
    public TubeCreateServlet(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JSP_TUBE_CREATE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        TubeBindingModel tube = (TubeBindingModel) req.getAttribute(ATTRIBUTE_BINDING_MODEL);
        this.tubeService.save(tube);
        resp.sendRedirect(URL_TUBE_DETAILS_ATR_TITLE + tube.getTitle());
    }
}
