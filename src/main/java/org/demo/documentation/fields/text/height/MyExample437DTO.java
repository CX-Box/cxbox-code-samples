package org.demo.documentation.fields.text.height;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample437DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample437DTO(MyEntity437 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}