package org.demo.documentation.text.validationbusinessex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample49DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample49DTO(MyEntity49 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}