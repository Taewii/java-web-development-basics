package p02_http_parser_improved;

import java.util.HashSet;
import java.util.Set;

final class Constants {

    static final String LINE_SEPARATOR = "\r\n";
    static final String BODY_PARAM_SEPARATOR = "[=&]";
    static final String HEADER_PARAM_SEPARATOR = ": ";

    static final String NOT_FOUND_MESSAGE = "The requested functionality was not found.";
    static final String UNAUTHORIZED_MESSAGE = "You are not authorized to access the requested functionality.";
    static final String BAD_REQUEST_MESSAGE = "There was an error with the requested functionality due to malformed request.";
    static final String OK_MESSAGE = "Greetings %s! You have successfully created %s with %s.";

    static final String AUTHORIZATION = "Authorization";
    private static final String DATE = "Date";
    private static final String HOST = "Host";
    private static final String CONTENT_TYPE = "Content-Type";

    static final Set<String> NEEDED_HEADERS = new HashSet<>() {{
        add(DATE);
        add(HOST);
        add(CONTENT_TYPE);
    }};

    private Constants() {
    }
}


