package metube.web.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class FilterUtil {

    public static boolean isGuest(HttpSession session) {
        return !isAuthenticated(session);
    }

    public static boolean isAuthenticated(HttpSession session) {
        return session != null && session.getAttribute("user") != null;
    }

    public static <T> T mapParamsToEntity(HttpServletRequest req, Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            T instance = constructor.newInstance();

            for (Field field : instance.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                String value = req.getParameter(fieldName);

                if (value != null) {
                    // TODO: 27.5.2019 г. parse value to desired type
                    field.set(instance, value);
                }
            }

            return instance;
        } catch (NoSuchMethodException |
                IllegalAccessException |
                InstantiationException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String extractIdFromYoutubeLink(String youtubeLink) {
        String videoId = youtubeLink.split("v=")[1];
        int ampersandPosition = videoId.indexOf('&');
        if (ampersandPosition != -1) {
            videoId = videoId.substring(0, ampersandPosition);
        }

        return videoId;
    }
}
