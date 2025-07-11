package org.demo.documentation.feature.postaction.waituntil.allbutton;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.feature.postaction.enums.StatusEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3231DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "statusResponse", provider = EnumValueProvider.class)
    private StatusEnum statusResponse;
    @SearchParameter(name = "customFieldForm")
    private String customFieldForm;

    private Boolean statusResponseFlag;

    public MyExample3231DTO(MyEntity3231 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.statusResponse = entity.getStatusResponse();
        this.customFieldForm = entity.getCustomFieldForm();
        this.statusResponseFlag = entity.getStatusResponse() == StatusEnum.DONE || entity.getStatusResponse() == StatusEnum.ERROR;
    }
}