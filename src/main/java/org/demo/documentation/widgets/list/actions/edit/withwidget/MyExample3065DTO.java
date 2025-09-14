package org.demo.documentation.widgets.list.actions.edit.withwidget;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3065DTO extends DataResponseDTO {
    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldText")
    private String customFieldText;

    @SearchParameter(name = "dfgjhklEntity.customField", provider = DateValueProvider.class)
    private LocalDateTime dfgjhkl;

    @SearchParameter(name = "dfgjhklEntity.id", provider = LongValueProvider.class)
    private Long dfgjhklId;

    @SearchParameter(name = "fjhjklEntity.name", provider = StringValueProvider.class)
    private String fjhjkl;

    @SearchParameter(name = "fjhjklEntity.id", provider = LongValueProvider.class)
    private Long fjhjklId;

    @SearchParameter(name = "hkjhkjList.id", provider = LongValueProvider.class)
    private MultivalueField hkjhkj;

    private String hkjhkjDisplayedKey;

    @SearchParameter(name = "dsfgsgsEntity.customField", provider = LongValueProvider.class)
    private Long dsfgsgs;

    @SearchParameter(name = "dsfgsgsEntity.id", provider = LongValueProvider.class)
    private Long dsfgsgsId;

    @SearchParameter(name = "fdsfdsfEntity.customField", provider = StringValueProvider.class)
    private String fdsfdsf;

    @SearchParameter(name = "fdsfdsfEntity.id", provider = LongValueProvider.class)
    private Long fdsfdsfId;

    public MyExample3065DTO(MyEntity3065 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldText = entity.getCustomFieldText();
        this.dfgjhklId = Optional.ofNullable(entity.getDfgjhklEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.dfgjhkl = Optional.ofNullable(entity.getDfgjhklEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.fjhjklId = Optional.ofNullable(entity.getFjhjklEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.fjhjkl = Optional.ofNullable(entity.getFjhjklEntity())
                .map(e -> e.getName())
                .orElse(null);
        this.hkjhkj = entity.getHkjhkjList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                e -> String.valueOf(e.getName())
        ));
        this.hkjhkjDisplayedKey = StringUtils.abbreviate(entity.getHkjhkjList().stream().map(ApplicationEntity::getName
        ).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
        this.dsfgsgsId = Optional.ofNullable(entity.getDsfgsgsEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.dsfgsgs = Optional.ofNullable(entity.getDsfgsgsEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.fdsfdsfId = Optional.ofNullable(entity.getFdsfdsfEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.fdsfdsf = Optional.ofNullable(entity.getFdsfdsfEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }
}