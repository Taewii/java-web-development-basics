package chushka.domain.entities.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TypeConverter implements AttributeConverter<Type, String> {

    @Override
    public String convertToDatabaseColumn(Type attribute) {
        return attribute.name();
    }

    @Override
    public Type convertToEntityAttribute(String dbData) {
        return Type.valueOf(dbData);
    }
}
