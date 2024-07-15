package org.demo.documentation.fields.multivalue.validationannotation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity199MultivalueDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyEntity199MultivalueDTO(MyEntity199 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
