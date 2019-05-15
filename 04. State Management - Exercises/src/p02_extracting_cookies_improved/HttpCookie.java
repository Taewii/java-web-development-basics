package p02_extracting_cookies_improved;

public class HttpCookie {

    private final String key;
    private final String value;

    public HttpCookie(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
