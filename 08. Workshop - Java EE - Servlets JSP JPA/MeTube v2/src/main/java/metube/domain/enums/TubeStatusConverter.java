package metube.domain.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TubeStatusConverter implements AttributeConverter<TubeStatus, String> {
    @Override
    public String convertToDatabaseColumn(TubeStatus attribute) {
        return attribute.toString();
    }

    @Override
    public TubeStatus convertToEntityAttribute(String dbData) {
        return TubeStatus.valueOf(dbData);
    }
}
