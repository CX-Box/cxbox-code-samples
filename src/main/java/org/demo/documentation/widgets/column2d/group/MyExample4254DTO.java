package org.demo.documentation.widgets.column2d.group;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample4254DTO extends DataResponseDTO {

	private String clientName;

	private String productName;

	private Long sum;
}
