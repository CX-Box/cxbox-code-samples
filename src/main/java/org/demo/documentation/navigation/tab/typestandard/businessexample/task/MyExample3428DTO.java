package org.demo.documentation.navigation.tab.typestandard.businessexample.task;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3428DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldDrilldown")
    private String customFieldDrilldown;
    @SearchParameter(name = "customFieldAdditional")
    private String customFieldAdditional;
    @SearchParameter(name = "meetDate", provider = DateValueProvider.class)
    private LocalDateTime meetDate;

    public MyExample3428DTO(MyEntity3428 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDrilldown = entity.getCustomFieldDrilldown();
        this.customFieldAdditional = entity.getCustomFieldAdditional();
        this.meetDate = entity.getMeetDate();
    }
}