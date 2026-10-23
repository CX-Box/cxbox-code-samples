package org.demo.documentation.widgets.line2d.filtergroup;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample4274DTO extends DataResponseDTO {

	private String month;

	@SearchParameter(name = "sum", provider = LongValueProvider.class)
	private Long sum;

}
