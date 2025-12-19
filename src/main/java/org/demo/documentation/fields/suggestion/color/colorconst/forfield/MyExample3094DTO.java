package org.demo.documentation.fields.suggestion.color.colorconst.forfield;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.fields.suggestion.color.colorconst.forfield.enums.ResidentTypeEnum;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3094DTO extends DataResponseDTO {

    private String customField;
    private String customFieldDate;

    @SearchParameter(name = "residentType", provider = EnumValueProvider.class)
    private ResidentTypeEnum residentType;

    @SearchParameter(name = "rusShortNameEntity.customField", provider = StringValueProvider.class)
    private String rusShortName;

    @SearchParameter(name = "rusShortNameEntity.id", provider = LongValueProvider.class)
    private Long rusShortNameId;

    @SearchParameter(name = "rusFullName", provider = StringValueProvider.class)
    private String rusFullName;

    @SearchParameter(name = "inn", provider = StringValueProvider.class)
    private String inn;

    @SearchParameter(name = "inn2Entity.inn", provider = StringValueProvider.class)
    private String inn2;

    @SearchParameter(name = "inn2Entity.id", provider = LongValueProvider.class)
    private Long inn2Id;

    public MyExample3094DTO(MyEntity3094 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDate = entity.getCustomFieldDate();
        this.residentType = entity.getResidentType();
        this.rusShortNameId = Optional.ofNullable(entity.getRusShortNameEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.rusShortName = Optional.ofNullable(entity.getRusShortNameEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.rusFullName = entity.getRusFullName();
        this.inn = entity.getInn();
        this.inn2Id = Optional.ofNullable(entity.getInn2Entity())
                .map(e -> e.getId())
                .orElse(null);
        this.inn2 = Optional.ofNullable(entity.getInn2Entity())
                .map(e -> e.getInn())
                .orElse(null);
    }
}