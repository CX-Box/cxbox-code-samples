package org.demo.documentation.widgets.line2d.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample4240DTO extends DataResponseDTO {

	private String month;

	private Long sum;

}
