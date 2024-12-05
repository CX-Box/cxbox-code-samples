package org.demo.documentation.feature.administration.dictionary;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.cxbox.model.dictionary.entity.DictionaryItem;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class DictionaryItemDTO extends DataResponseDTO {

    @SearchParameter
    private String key;

    @SearchParameter
    private String value;

    @SearchParameter(provider = BooleanValueProvider.class)
    private Boolean active;

    @SearchParameter
    private String type;

    @SearchParameter(name = "dictionaryTypeId.id", provider = LongValueProvider.class)
    private Long dictionaryTypeId;

    @SearchParameter(provider = BigDecimalValueProvider.class)
    private Integer displayOrder;

    @SearchParameter
    private String description;

    public DictionaryItemDTO(DictionaryItem dictionaryItem) {
        this.id = dictionaryItem.getId().toString();
        this.dictionaryTypeId = Optional.ofNullable(dictionaryItem.getDictionaryTypeId()).map(BaseEntity::getId).orElse(null);
        this.key = dictionaryItem.getKey();
        this.value = dictionaryItem.getValue();
        this.active = dictionaryItem.isActive();
        this.type = dictionaryItem.getType();
        this.displayOrder = dictionaryItem.getDisplayOrder();
        this.description = dictionaryItem.getDescription();
    }

}
