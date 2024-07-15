package org.demo.documentation.fields.multifield.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample360DTO extends DataResponseDTO {

    @SearchParameter(name = "customFieldAdditional")
    private String customFieldAdditional;
    private String informationField;
    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldAdditionalMulti")
    private String customFieldAdditionalMulti;
    @SearchParameter(name = "customFieldMulti")
    private String customFieldMulti;

    public MyExample360DTO(MyEntity360 entity) {
        this.id = entity.getId().toString();
        this.customFieldAdditional = entity.getCustomFieldAdditional();
        this.informationField = entity.getInformationField();
        this.customField = entity.getCustomField();
        this.customFieldAdditionalMulti = entity.getCustomFieldAdditionalMulti();
        this.customFieldMulti = entity.getCustomFieldMulti();
    }
}