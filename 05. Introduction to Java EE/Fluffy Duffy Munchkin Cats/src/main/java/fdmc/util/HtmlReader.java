package fdmc.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class HtmlReader implements Reader {
    @Override
    public String readHtmlFile(String path) {
        InputStream inputStream;
        String content = null;

        if (path != null && (inputStream = getClass().getResourceAsStream(path)) != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            content = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }

        return content;
    }
}
