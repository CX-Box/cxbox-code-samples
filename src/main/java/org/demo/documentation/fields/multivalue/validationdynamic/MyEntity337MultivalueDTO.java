package org.demo.documentation.fields.multivalue.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity337MultivalueDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	private String customFieldAdditional;

	public MyEntity337MultivalueDTO(MyEntity337 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldAdditional = entity.getCustomFieldAdditional();
	}

}
