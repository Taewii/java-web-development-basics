package p02_http_parser_improved;

public enum StatusCode {
    NOT_FOUND(404, "The requested functionality was not found."),
    UNAUTHORIZED(401, "You are not authorized to access the requested functionality."),
    MALFORMED_REQUEST(400, "There was an error with the requested functionality due to malformed request.");

    private int statusCode;
    private String responseBody;

    StatusCode(int statusCode, String responseBody) {
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }
}
