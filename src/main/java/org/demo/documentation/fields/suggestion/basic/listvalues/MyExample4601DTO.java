package org.demo.documentation.fields.suggestion.basic.listvalues;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4601DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample4601DTO(MyEntity4601 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}