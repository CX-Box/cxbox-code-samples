package org.demo.documentation.fields.checkbox.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample82DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = BooleanValueProvider.class)
    private Boolean customField;

    @SearchParameter(name = "dsgfsg", provider = StringValueProvider.class)
    private String dsgfsg;

    @SearchParameter(name = "customField5", provider = BooleanValueProvider.class)
    private Boolean customField5;

    @SearchParameter(name = "customField4", provider = StringValueProvider.class)
    private String customField4;

    @SearchParameter(name = "customField6", provider = StringValueProvider.class)
    private String customField6;

    @SearchParameter(name = "customField2", provider = BooleanValueProvider.class)
    private Boolean customField2;

    @SearchParameter(name = "customField3", provider = StringValueProvider.class)
    private String customField3;

    @SearchParameter(name = "customField7", provider = BooleanValueProvider.class)
    private Boolean customField7;

    @SearchParameter(name = "customField8", provider = StringValueProvider.class)
    private String customField8;

    @SearchParameter(name = "customField9", provider = BooleanValueProvider.class)
    private Boolean customField9;

    public MyExample82DTO(MyEntity82 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.dsgfsg = entity.getDsgfsg();
        this.customField5 = entity.getCustomField5();
        this.customField4 = entity.getCustomField4();
        this.customField6 = entity.getCustomField6();
        this.customField2 = entity.getCustomField2();
        this.customField3 = entity.getCustomField3();
        this.customField7 = entity.getCustomField7();
        this.customField8 = entity.getCustomField8();
        this.customField9 = entity.getCustomField9();
    }

}