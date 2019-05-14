package p01_http_parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HttpParser {

    private static final String DATE = "Date";
    private static final String HOST = "Host";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String AUTHORIZATION = "Authorization";
    private static Map<String, String> headers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> urls = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        headers = new LinkedHashMap<>();
        String method = "";

        String input;
        while ((input = reader.readLine()).length() != 0 && input != null) {
            String[] params = input.split(": ");
            if (params.length == 1) {
                method = params[0];
            } else {
                headers.put(params[0], params[1]);
            }
        }

        String[] path = method.split("\\s+");
        String bodyParamsStr = reader.readLine();
        String[] bodyParams = null;
        if (bodyParamsStr != null) {
            bodyParams = bodyParamsStr.split("[&=]");
        }

        String result;
        if (!urls.contains(path[1])) {
            result = constructOutput("404 Not Found", "The requested functionality was not found.");
        } else if (!headers.containsKey(AUTHORIZATION)) {
            result = constructOutput("401 Unauthorized", "You are not authorized to access the requested functionality.");
        } else if (path[0].equals("POST") && bodyParams == null) {
            result = constructOutput("400 Bad Request", "There was an error with the requested functionality due to malformed request.");
        } else {
            result = constructOutput("200 OK", getResponseBody(bodyParams));
        }

        System.out.println(result);
    }

    private static String getResponseBody(String[] bodyParams) {
        byte[] decodedUsername = Base64.getDecoder().decode(headers.get(AUTHORIZATION).split("\\s+")[1]);
        String username = new String(decodedUsername);

        List<String> connectedBodyParameters = new ArrayList<>();
        for (int i = 2; i < bodyParams.length - 1; i += 2) {
            connectedBodyParameters.add(bodyParams[i] + " - " + bodyParams[i + 1]);
        }

        return String.format("Greetings %s! You have successfully created %s with %s.",
                username, bodyParams[1], String.join(", ", connectedBodyParameters));
    }

    private static String constructOutput(String status, String body) {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 ").append(status).append(System.lineSeparator());

        headers.forEach((k, v) -> {
            if (k.equals(DATE) || k.equals(CONTENT_TYPE) || k.equals(HOST)) {
                sb.append(k).append(": ").append(v).append(System.lineSeparator());
            }
        });

        sb.append(System.lineSeparator());
        sb.append(body).append(System.lineSeparator());

        return sb.toString();
    }
}
