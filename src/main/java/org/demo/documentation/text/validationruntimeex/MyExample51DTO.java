package org.demo.documentation.text.validationruntimeex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample51DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample51DTO(MyEntity51 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}