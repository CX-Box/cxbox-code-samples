package org.demo.documentation.fields.multivalue.primary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity2001MultivalueDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyEntity2001MultivalueDTO(MyEntity2001 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
