package metube.web.servlets.tube;

import metube.domain.entities.Tube;
import metube.domain.enums.TubeStatus;
import metube.services.TubeService;
import metube.web.WebConstants;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/tube/decline/*")
public class DeclineServlet extends HttpServlet {

    private final TubeService tubeService;

    @Inject
    public DeclineServlet(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getPathInfo().substring(1);
        Tube tube = this.tubeService.findById(id);
        tube.changeStatus(TubeStatus.DECLINED);
        this.tubeService.update(tube);

        resp.sendRedirect(WebConstants.HOME_URL);
    }
}
