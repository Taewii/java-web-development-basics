package chushka.domain.entities.enums;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public enum Type {
    FOOD("Food"),
    DOMESTIC("Domestic"),
    HEALTH("Health"),
    COSMETIC("Cosmetic"),
    OTHER("Other");

    private static final Map<String, Type> NAME_TO_ENUM_MAP = Stream.of(Type.values())
            .collect(
                    LinkedHashMap::new,                              // Supplier
                    (map, type) -> map.put(type.getName(), type),    // Accumulator
                    Map::putAll);                                    // Combiner

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public static Type getTypeFromName(String name) {
        return name == null ? null : NAME_TO_ENUM_MAP.get(name);
    }

    public static String getTypesAsHtmlOptions() {
        StringBuilder sb = new StringBuilder();
        for (Type type : NAME_TO_ENUM_MAP.values()) {
            sb.append(String.format("<option value=\"%s\">%s</option>", type.getName(), type.getName()))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getName() {
        return this.name;
    }
}
