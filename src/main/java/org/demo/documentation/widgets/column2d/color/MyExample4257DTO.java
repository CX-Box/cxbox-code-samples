package org.demo.documentation.widgets.column2d.color;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample4257DTO extends DataResponseDTO {

	private String clientName;

	private String productName;

	private Long sum;

	private String color;
}
