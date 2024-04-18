package org.demo.documentation.multivalue.validationruntimeex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity197MultivalueDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyEntity197MultivalueDTO(MyEntity197 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
