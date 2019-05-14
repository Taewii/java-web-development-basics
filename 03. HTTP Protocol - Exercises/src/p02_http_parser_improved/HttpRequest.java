package p02_http_parser_improved;

import java.util.Map;

public interface HttpRequest {

    Map<String, String> getHeaders();

    Map<String, String> getBodyParameters();

    String getMethod();

    void setRequestUrl(String requestUrl);

    void addHeader(String header, String value);

    void addBodyParameter(String parameter, String value);

    boolean isResource();
}
