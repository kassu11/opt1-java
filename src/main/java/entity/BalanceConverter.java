package entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BalanceConverter implements AttributeConverter<Double, Integer> {

    // Convert double to integer
    @Override
    public Integer convertToDatabaseColumn(Double attribute) {
        if (attribute == null) {
            return null;
        }
        return (int) (attribute * 100);
    }

    // Convert integer back to double
    @Override
    public Double convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return dbData / 100.0;
    }
}
