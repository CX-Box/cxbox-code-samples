package org.demo.documentation.widgets.list.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;



@Getter
@Setter
@NoArgsConstructor
public class MyExample3002DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample3002DTO(MyEntity3002 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}