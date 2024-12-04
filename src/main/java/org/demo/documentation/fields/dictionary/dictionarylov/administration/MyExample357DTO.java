package org.demo.documentation.fields.dictionary.dictionarylov.administration;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample357DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "typeEntity.type", provider = StringValueProvider.class)
    private String type;
    @SearchParameter(name = "typeEntity.id", provider = LongValueProvider.class)
    private Long typeId;
    @SearchParameter(name = "key", provider = StringValueProvider.class)
    private String key;
    @SearchParameter(name = "value", provider = StringValueProvider.class)
    private String value;
    @SearchParameter(name = "displayOrder", provider = BigDecimalValueProvider.class)
    private Long displayOrder;
    @SearchParameter(name = "description", provider = StringValueProvider.class)
    private String description;
    @SearchParameter(name = "active", provider = BooleanValueProvider.class)
    private Boolean active;

    public MyExample357DTO(MyEntity357 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.typeId = Optional.ofNullable(entity.getTypeEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.type = Optional.ofNullable(entity.getTypeEntity())
                .map(e -> e.getType())
                .orElse(null);
        this.key = entity.getKey();
        this.value = entity.getValue();
        this.displayOrder = entity.getDisplayOrder();
        this.description = entity.getDescription();
        this.active = entity.getActive();
    }
}