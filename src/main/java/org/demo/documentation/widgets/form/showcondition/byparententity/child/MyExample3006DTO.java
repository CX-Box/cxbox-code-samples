package org.demo.documentation.widgets.form.showcondition.byparententity.child;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3006DTO extends DataResponseDTO {

    public static final String TEXT = "Condition can include boolean expression depending on parent entity. Parent field updates will trigger condition recalculation only on save or if field is force active shown on same view";

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample3006DTO(MyEntity3006 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}