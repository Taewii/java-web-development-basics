package fdmc.util;

import java.io.FileNotFoundException;

public interface Reader {

    String readHtmlFile(String path) throws FileNotFoundException;
}
