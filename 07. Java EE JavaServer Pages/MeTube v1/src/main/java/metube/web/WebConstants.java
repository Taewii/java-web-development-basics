package metube.web;

public final class WebConstants {

    public static final String ATTRIBUTE_TUBE = "tube";
    public static final String ATTRIBUTE_TITLE = "title";
    public static final String ATTRIBUTE_DESCRIPTION = "description";
    public static final String ATTRIBUTE_YOUTUBE_LINK = "youtube-link";
    public static final String ATTRIBUTE_UPLOADER = "uploader";
    public static final String ATTRIBUTE_ALL_TUBES = "allTubes";
    public static final String ATTRIBUTE_BINDING_MODEL = "tubeBindingModel";

    public static final String URL_INDEX = "";
    private static final String URL_TUBE_BASE = "/tube";
    public static final String URL_TUBE_ALL = URL_TUBE_BASE + "/all";
    public static final String URL_TUBE_DETAILS = URL_TUBE_BASE + "/details";
    public static final String URL_TUBE_CREATE = URL_TUBE_BASE + "/create";
    public static final String URL_TUBE_DETAILS_ATR_TITLE = URL_TUBE_BASE + "/details?" + ATTRIBUTE_TITLE + "=";

    private static final String JSP_BASE_LOCATION = "/WEB-INF/views";
    public static final String JSP_INDEX = JSP_BASE_LOCATION + "/index.jsp";
    public static final String JSP_TUBE_DETAILS = JSP_BASE_LOCATION + "/tube-details.jsp";
    public static final String JSP_TUBE_ALL = JSP_BASE_LOCATION + "/tube-all.jsp";
    public static final String JSP_TUBE_CREATE = JSP_BASE_LOCATION + "/tube-create.jsp";

    private WebConstants() {
    }
}
