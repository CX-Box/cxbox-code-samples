package org.demo.documentation.widgets.column2d.limit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample4259DTO extends DataResponseDTO {

	private String clientName;

	private Long sum;
}
