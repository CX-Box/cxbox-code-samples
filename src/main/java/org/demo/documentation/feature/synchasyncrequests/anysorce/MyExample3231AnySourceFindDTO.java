package org.demo.documentation.feature.synchasyncrequests.anysorce;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3231AnySourceFindDTO extends DataResponseDTO {
    private String customField;
    private String customFieldForm;
    public MyExample3231AnySourceFindDTO(MyEntity3231AnySourceOutServiceFindDTO entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldForm = entity.getCustomFieldForm();
    }
}