package p02_http_parser_improved;

import java.util.Map;

public class HttpRequestImpl implements HttpRequest {

    @Override
    public Map<String, String> getHeaders() {
        return null;
    }

    @Override
    public Map<String, String> getBodyParameters() {
        return null;
    }

    @Override
    public String getMethod() {
        return null;
    }

    @Override
    public void setRequestUrl(String requestUrl) {

    }

    @Override
    public void addHeader(String header, String value) {

    }

    @Override
    public void addBodyParameter(String parameter, String value) {

    }

    @Override
    public boolean isResource() {
        return false;
    }
}
