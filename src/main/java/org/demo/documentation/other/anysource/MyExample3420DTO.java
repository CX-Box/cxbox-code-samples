package org.demo.documentation.other.anysource;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;

import java.time.LocalDateTime;

import static org.demo.documentation.fields.main.TextError.ONLY_LETTER;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3420DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    @Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
    private String customField;

    @SearchParameter(name = "customFieldNew")
    @Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
    private String customFieldNew;

    private LocalDateTime customFieldDateTime;

    public MyExample3420DTO(MyEntity3420OutServiceDTO entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldNew = entity.getCustomFieldNew();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
    }
}