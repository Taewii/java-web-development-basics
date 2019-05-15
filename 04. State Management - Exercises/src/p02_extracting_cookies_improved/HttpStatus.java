package p02_extracting_cookies_improved;

public enum HttpStatus {
    OK(200, "OK"),
    NOT_FOUND(404, "Not Found"),
    UNAUTHORIZED(401, "Unauthorized"),
    MALFORMED_REQUEST(400, "Bad Request");

    private int code;
    private String statusText;

    HttpStatus(int code, String statusText) {
        this.code = code;
        this.statusText = statusText;
    }

    public int getCode() {
        return this.code;
    }

    public String getStatusText() {
        return this.statusText;
    }

    @Override
    public String toString() {
        return this.getCode() + " " + this.getStatusText();
    }
}
