package org.demo.documentation.fields.richtext.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample425DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample425DTO(MyEntity425 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
