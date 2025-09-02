package org.demo.documentation.widgets.headerwidget.showcondition.byparententity.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5030DTO extends DataResponseDTO {

    public static final String INFO_TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

    public static final String INFO_TEXT2 = "Show condition child widget  - if CustomField  > 5 widget show.";

    private Long customField;

    private Boolean customFieldShowCondition;

    public MyExample5030DTO(MyEntity5030 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldShowCondition = entity.getCustomField() > 5 ;
    }
}
