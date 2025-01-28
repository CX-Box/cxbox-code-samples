package org.demo.documentation.feature.synchasyncrequests.anysorce;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3231AnySourceDTO extends DataResponseDTO {
    private String customField;
    public MyExample3231AnySourceDTO(MyEntity3231AnySourceOutServiceDTO entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}