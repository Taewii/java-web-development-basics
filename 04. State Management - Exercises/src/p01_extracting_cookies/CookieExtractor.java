package p01_extracting_cookies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class CookieExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] methodUrlAndHttpVersion = reader.readLine().split("\\s+");
        String method = methodUrlAndHttpVersion[0];
        String requestUrl = methodUrlAndHttpVersion[1];
        String http = methodUrlAndHttpVersion[2];

        Map<String, String> headers = new LinkedHashMap<>();
        Map<String, String> cookies = new LinkedHashMap<>();
        Map<String, String> body = new LinkedHashMap<>();

        String input;
        while ((input = reader.readLine()).length() != 0 && !input.contains("Cookie")) {
            String[] params = input.split(": ");
            headers.put(params[0], params[1]);
        }

        String[] cookieParams = input.split("[:&=\\s]+");

        for (int i = 1; i < cookieParams.length - 1; i += 2) {
            cookies.put(cookieParams[i], cookieParams[i + 1]);
        }

        reader.readLine(); //empty line
        String bodyInput = reader.readLine();

        if (bodyInput != null) {
            String[] bodyParams = bodyInput.split("[=&]");

            for (int i = 0; i < bodyParams.length - 1; i += 2) {
                body.put(bodyParams[i], bodyParams[i + 1]);
            }
        }

        cookies.forEach((k, v) -> System.out.println(k + " <-> " + v));
    }
}