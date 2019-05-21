package metube.web.servlets;

import metube.domain.models.view.TubeDetailsViewModel;
import metube.services.TubeService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tube/details")
public class TubeDetailsServlet extends HttpServlet {

    private final TubeService tubeService;

    @Inject
    public TubeDetailsServlet(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        TubeDetailsViewModel tube = this.tubeService.findByTitle(title);
        req.setAttribute("tube", tube);
        req.getRequestDispatcher("/templates/tube-details.jsp").forward(req, resp);
    }
}
