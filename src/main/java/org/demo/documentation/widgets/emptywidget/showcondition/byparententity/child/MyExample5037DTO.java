package org.demo.documentation.widgets.emptywidget.showcondition.byparententity.child;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5037DTO extends DataResponseDTO {

    public static final String TEXT = "Condition can include boolean expression depending on parent entity. Parent field updates will trigger condition recalculation only on save or if field is force active shown on same view";

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample5037DTO(MyEntity5037 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}
