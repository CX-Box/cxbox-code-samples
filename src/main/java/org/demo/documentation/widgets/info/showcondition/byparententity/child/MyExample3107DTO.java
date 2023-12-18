package org.demo.documentation.widgets.info.showcondition.byparententity.child;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3107DTO extends DataResponseDTO {

    public static final String TEXT = "condition can include boolean expression depending on parent entity. Parent field updates will trigger condition recalculation only on save or if field is force active shown on same view";

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private Long customField;
    @SearchParameter(name = "customField2", provider = StringValueProvider.class)
    private String customField2;
    @SearchParameter(name = "customField3", provider = StringValueProvider.class)
    private String customField3;
    public MyExample3107DTO(MyEntity3107 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();

        this.customField2 = TEXT;

        this.customField3 = "true";/// entity.getCustomField() > 6 ? "true" : "false";

    }
}