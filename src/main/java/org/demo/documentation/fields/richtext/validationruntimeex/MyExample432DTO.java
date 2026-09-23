package org.demo.documentation.fields.richtext.validationruntimeex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample432DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample432DTO(MyEntity432 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}