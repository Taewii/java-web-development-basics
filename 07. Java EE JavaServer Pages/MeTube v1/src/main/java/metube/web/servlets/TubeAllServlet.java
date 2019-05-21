package metube.web.servlets;

import metube.domain.models.view.TubeAllViewModel;
import metube.services.TubeService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tube/all")
public class TubeAllServlet extends HttpServlet {

    private final TubeService tubeService;

    @Inject
    public TubeAllServlet(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TubeAllViewModel> tubes = this.tubeService.findAll();
        req.setAttribute("allTubes", tubes);
        req.getRequestDispatcher("/templates/tube-all.jsp").forward(req, resp);
    }
}
