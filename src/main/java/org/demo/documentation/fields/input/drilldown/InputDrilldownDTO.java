package org.demo.documentation.fields.input.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class InputDrilldownDTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customField2")
    private String customField2;

    public InputDrilldownDTO(InputDrilldown entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customField2 = entity.getCustomField2();
    }

}