package p02_http_parser_improved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> validUrls = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        String input = constructInput(reader);
        HttpRequest request = new HttpRequestImpl(input);
        HttpResponse response = new HttpResponseImpl();

        for (Map.Entry<String, String> headerEntry : request.getHeaders().entrySet()) {
            response.addHeader(headerEntry.getKey(), headerEntry.getValue());
        }

        if (!validUrls.contains(request.getRequestUrl())) {
            response.setHttpStatus(HttpStatus.NOT_FOUND);
            response.setContent(Constants.NOT_FOUND_MESSAGE.getBytes());
        } else if (!request.getHeaders().containsKey(Constants.AUTHORIZATION)) {
            response.setHttpStatus(HttpStatus.UNAUTHORIZED);
            response.setContent(Constants.UNAUTHORIZED_MESSAGE.getBytes());
        } else if (request.getMethod().equals("POST") && request.getBodyParameters().isEmpty()) {
            response.setHttpStatus(HttpStatus.MALFORMED_REQUEST);
            response.setContent(Constants.BAD_REQUEST_MESSAGE.getBytes());
        } else {
            byte[] decodedUsername = Base64.getDecoder().decode(request.getHeaders().get(Constants.AUTHORIZATION).split("\\s+")[1]);
            String username = new String(decodedUsername);

            List<String> connectedBodyParams = new ArrayList<>();
            request.getBodyParameters().forEach((k, v) -> connectedBodyParams.add(k + " - " + v));

            String content = String.format(Constants.OK_MESSAGE,
                    username,
                    connectedBodyParams.get(0).split(" - ")[1],
                    connectedBodyParams.stream().skip(1).collect(Collectors.joining(", ")));

            response.setHttpStatus(HttpStatus.OK);
            response.setContent(content.getBytes());
        }

        System.out.println(new String(response.getBytes()));
    }

    private static String constructInput(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = reader.readLine()).length() != 0) {
            sb.append(input).append(System.lineSeparator());
        }

        sb.append(System.lineSeparator());
        sb.append(reader.readLine());

        return sb.toString();
    }
}
