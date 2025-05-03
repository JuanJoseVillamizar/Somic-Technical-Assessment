package JuanJose.PruebaSomic.utils;

import JuanJose.PruebaSomic.entities.TransactionType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TransactionTypeConverter implements AttributeConverter <TransactionType, String> {

    @Override
    public String convertToDatabaseColumn(TransactionType attribute) {
        return attribute == null ? null : String.valueOf(attribute.getCode());
    }

    @Override
    public TransactionType convertToEntityAttribute(String dbData) {
        return dbData == null ? null : TransactionType.fromCode(dbData.charAt(0));
    }
}
