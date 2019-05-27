package metube.web.filters;

import metube.domain.models.binding.RegisterBindingModel;
import metube.web.WebConstants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(WebConstants.REGISTER_URL)
public class RegisterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getMethod().equalsIgnoreCase(WebConstants.HTTP_METHOD_POST)) {
            RegisterBindingModel user = FilterUtil.mapParamsToEntity(req, RegisterBindingModel.class);
            req.setAttribute("model", user);
        }

        chain.doFilter(req, response);
    }
}
