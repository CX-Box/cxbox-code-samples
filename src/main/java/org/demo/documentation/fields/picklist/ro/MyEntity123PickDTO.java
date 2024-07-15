package org.demo.documentation.fields.picklist.ro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity123PickDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyEntity123PickDTO(MyEntity123 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
