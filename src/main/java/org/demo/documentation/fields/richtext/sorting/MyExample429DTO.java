package org.demo.documentation.fields.richtext.sorting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample429DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample429DTO(MyEntity429 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}