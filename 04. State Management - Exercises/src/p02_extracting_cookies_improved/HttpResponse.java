package p02_extracting_cookies_improved;

import java.util.Map;

public interface HttpResponse {

    Map<String, String> getHeaders();

    int getStatusCode();

    byte[] getContent();

    byte[] getBytes();

    void setStatusCode(int statusCode);

    void setContent(byte[] content);

    HttpStatus getHttpStatus();

    void setHttpStatus(HttpStatus httpStatus);

    void addHeader(String header, String value);
}
