package org.demo.documentation.widgets.pie1d.filtration;

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
public class MyExample4264DTO extends DataResponseDTO {

	@SearchParameter(name = "title")
	private String title;

	private Long value;

}
