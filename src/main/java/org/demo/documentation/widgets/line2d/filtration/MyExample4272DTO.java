package org.demo.documentation.widgets.line2d.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample4272DTO extends DataResponseDTO {

	@SearchParameter(name = "month")
	private String month;

	private Long sum;

}
