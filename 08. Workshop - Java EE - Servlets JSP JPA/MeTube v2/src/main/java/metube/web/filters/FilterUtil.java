package metube.web.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

final class FilterUtil {

    static boolean isAdmin(HttpSession session) {
        return isAuthenticated(session) && (boolean) session.getAttribute("isAdmin");
    }

    static boolean isGuest(HttpSession session) {
        return !isAuthenticated(session);
    }

    static boolean isAuthenticated(HttpSession session) {
        return session != null && session.getAttribute("user") != null;
    }

    static <T> T mapParamsToEntity(HttpServletRequest req, Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            T instance = constructor.newInstance();

            for (Field field : instance.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                String value = req.getParameter(fieldName);

                if (value != null) {
                    field.set(instance, parseValue(field.getType(), value));
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

    static String extractIdFromYoutubeLink(String youtubeLink) {
        String videoId = youtubeLink.split("v=")[1];
        int ampersandPosition = videoId.indexOf('&');
        if (ampersandPosition != -1) {
            videoId = videoId.substring(0, ampersandPosition);
        }

        return videoId;
    }

    private static Object parseValue(Class<?> type, String value) {
        if (type == null || value == null) {
            return null;
        }

        if (type.isAssignableFrom(int.class) || type.isAssignableFrom(Integer.class)) {
            return Integer.valueOf(value);
        } else if (type.isAssignableFrom(long.class) || type.isAssignableFrom(Long.class)) {
            return Long.valueOf(value);
        } else if (type.isAssignableFrom(float.class) || type.isAssignableFrom(Float.class)) {
            return Float.valueOf(value);
        } else if (type.isAssignableFrom(double.class) || type.isAssignableFrom(Double.class)) {
            return Double.valueOf(value);
        } else if (type.isAssignableFrom(boolean.class) || type.isAssignableFrom(Boolean.class)) {
            return Boolean.valueOf(value);
        } else {
            return value;
        }
    }
}
