package p02_http_parser_improved;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpRequestImpl implements HttpRequest {

    private final Map<String, String> headers;
    private final Map<String, String> bodyParameters;
    private String method;
    private String requestUrl;

    public HttpRequestImpl(String request) {
        this.headers = new LinkedHashMap<>();
        this.bodyParameters = new LinkedHashMap<>();
        this.initialize(request);
    }

    private void initialize(String request) {
        String[] lines = request.split(Constants.LINE_SEPARATOR);
        String[] methodAndRequestUrl = lines[0].split("\\s+");
        this.setMethod(methodAndRequestUrl[0]);
        this.setRequestUrl(methodAndRequestUrl[1]);

        for (int i = 1; i < lines.length; i++) {
            if (lines[i].length() == 0) {
                String[] bodyParams = lines[i + 1].split(Constants.BODY_PARAM_SEPARATOR);

                for (int j = 0; j < bodyParams.length - 1; j += 2) {
                    this.bodyParameters.put(bodyParams[j], bodyParams[j + 1]);
                }

                break;
            } else {
                String[] headerParams = lines[i].split(Constants.HEADER_PARAM_SEPARATOR);
                this.headers.put(headerParams[0], headerParams[1]);
            }
        }
    }

    @Override
    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(this.headers);
    }

    @Override
    public Map<String, String> getBodyParameters() {
        return Collections.unmodifiableMap(this.bodyParameters);
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public String getRequestUrl() {
        return this.requestUrl;
    }

    @Override
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.put(header, value);
    }

    @Override
    public void addBodyParameter(String parameter, String value) {
        this.bodyParameters.put(parameter, value);
    }

    @Override
    public boolean isResource() {
        return this.getRequestUrl().contains(".");
    }
}
