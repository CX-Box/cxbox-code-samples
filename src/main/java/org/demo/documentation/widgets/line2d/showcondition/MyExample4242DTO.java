package org.demo.documentation.widgets.line2d.showcondition;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample4242DTO extends DataResponseDTO {

	private String month;

	private Long sum;

}
