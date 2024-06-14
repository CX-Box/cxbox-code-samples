package org.demo.documentation.widgets.statsblock.base.defaultfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4203DTO extends DataResponseDTO {

    private String title;

    private Long value;

    private String color;

    private String description;

    private String icon;
}