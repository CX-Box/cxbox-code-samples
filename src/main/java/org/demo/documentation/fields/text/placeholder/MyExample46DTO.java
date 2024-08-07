package org.demo.documentation.fields.text.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample46DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample46DTO(MyEntity46 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}