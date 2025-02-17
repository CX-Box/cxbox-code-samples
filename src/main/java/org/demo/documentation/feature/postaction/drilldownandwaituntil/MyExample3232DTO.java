package org.demo.documentation.feature.postaction.drilldownandwaituntil;

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
public class MyExample3232DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "statusResponse", provider = EnumValueProvider.class)
    private StatusEnum statusResponse;
    @SearchParameter(name = "customFieldForm", provider = StringValueProvider.class)
    private String customFieldForm;

    private Boolean statusResponseFlag;

    public MyExample3232DTO(MyEntity3232 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldForm = entity.getCustomFieldForm();
        this.statusResponse = entity.getStatusResponse();
        this.statusResponseFlag = entity.getStatusResponse() == StatusEnum.DONE || entity.getStatusResponse() == StatusEnum.ERROR;
    }
}