package chushka.domain.entities.enums;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Type {
    FOOD("food"), DOMESTIC("domestic"), HEALTH("health"), COSMETIC("cosmetic"), OTHER("other");

    private static final Map<String, Type> NAME_TO_ENUM_MAP = Stream.of(Type.values())
            .collect(Collectors.toUnmodifiableMap(Type::getName, type -> type));

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public static Type getTypeFromName(String name) {
        return name == null ? null : NAME_TO_ENUM_MAP.get(name);
    }

    public String getName() {
        return this.name;
    }
}
