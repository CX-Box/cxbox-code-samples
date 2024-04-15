package org.demo.documentation.multivalue.ro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity181MultivalueDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyEntity181MultivalueDTO(MyEntity181 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
