package metube.web.filters;

import metube.domain.models.binding.UploadTubeBindingModel;
import metube.web.WebConstants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(WebConstants.UPLOAD_URL)
public class UploadFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getMethod().equalsIgnoreCase(WebConstants.HTTP_METHOD_POST)) {
            UploadTubeBindingModel tube = FilterUtil.mapParamsToEntity(req, UploadTubeBindingModel.class);
            tube.setYoutubeId(FilterUtil.extractIdFromYoutubeLink(tube.getYoutubeId()));
            request.setAttribute("model", tube);
        }

        chain.doFilter(req, response);
    }
}
