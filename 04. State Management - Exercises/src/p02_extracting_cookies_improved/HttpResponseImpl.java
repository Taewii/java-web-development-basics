package p02_extracting_cookies_improved;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpResponseImpl implements HttpResponse {

    private final Map<String, String> headers;
    private int statusCode;
    private byte[] content;
    private HttpStatus httpStatus;

    public HttpResponseImpl() {
        this.headers = new LinkedHashMap<>();
        this.content = new byte[0];
    }

    @Override
    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(this.headers);
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.setStatusCode(httpStatus.getCode());
    }

    @Override
    public byte[] getContent() {
        return this.content.clone();
    }

    @Override
    public byte[] getBytes() {
        StringBuilder res = new StringBuilder()
                .append("HTTP/1.1").append(" ").append(this.getHttpStatus())
                .append(System.lineSeparator());

        this.getHeaders().forEach((k, v) -> {
            if (Constants.NEEDED_HEADERS.contains(k)) {
                res.append(String.format("%s: %s%n", k, v));
            }
        });

        res.append(System.lineSeparator());
        res.append(new String(this.getContent()));

        return res.toString().getBytes();
    }

    @Override
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public void setContent(byte[] content) {
        this.content = content.clone();
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.put(header, value);
    }
}
