package metube.web;

public final class WebConstants {

    public static final String HTTP_METHOD_POST = "POST";
    public static final String INDEX_URL = "/";
    public static final String REGISTER_URL = "/register";
    public static final String LOGIN_URL = "/login";
    public static final String LOGOUT_URL = "/logout";
    public static final String HOME_URL = "/home";
    public static final String PROFILE_URL = "/profile";
    public static final String UPLOAD_URL = "/upload";
    private static final String TUBE = "/tube";
    private static final String ADMIN_URL = "/admin";
    private static final String DETAILS_URL = "/details";
    private static final String PENDING_URL = "/pending";
    public static final String ADMIN_PENDING_URL = ADMIN_URL + TUBE + PENDING_URL;

    private static final String VIEWS_PATH = "/WEB-INF/views";
    private static final String JSP_EXTENSION = ".jsp";
    public static final String REGISTER_VIEW_JSP = VIEWS_PATH + REGISTER_URL + JSP_EXTENSION;
    public static final String LOGIN_VIEW_JSP = VIEWS_PATH + LOGIN_URL + JSP_EXTENSION;
    public static final String DETAILS_VIEW_JSP = VIEWS_PATH + DETAILS_URL + JSP_EXTENSION;
    public static final String HOME_VIEW_JSP = VIEWS_PATH + HOME_URL + JSP_EXTENSION;
    public static final String PROFILE_VIEW_JSP = VIEWS_PATH + PROFILE_URL + JSP_EXTENSION;
    public static final String UPLOAD_VIEW_JSP = VIEWS_PATH + UPLOAD_URL + JSP_EXTENSION;
    public static final String PENDING_VIEW_JSP = VIEWS_PATH + PENDING_URL + JSP_EXTENSION;
    private static final String JSP_INDEX_URL = "/index";
    public static final String INDEX_VIEW_JSP = VIEWS_PATH + JSP_INDEX_URL + JSP_EXTENSION;

    private WebConstants() {
    }
}
