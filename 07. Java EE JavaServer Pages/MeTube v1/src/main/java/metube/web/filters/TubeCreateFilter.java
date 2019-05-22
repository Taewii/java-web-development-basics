package metube.web.filters;

import metube.domain.models.binding.TubeBindingModel;
import metube.web.WebConstants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static metube.web.WebConstants.*;

@WebFilter(WebConstants.URL_TUBE_CREATE)
public class TubeCreateFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        TubeBindingModel tube = new TubeBindingModel();

        tube.setTitle(req.getParameter(ATTRIBUTE_TITLE));
        tube.setDescription(req.getParameter(ATTRIBUTE_DESCRIPTION));
        tube.setYoutubeLink(req.getParameter(ATTRIBUTE_YOUTUBE_LINK));
        tube.setUploader(req.getParameter(ATTRIBUTE_UPLOADER));

        req.setAttribute(ATTRIBUTE_BINDING_MODEL, tube);

        chain.doFilter(req, response);
    }
}
