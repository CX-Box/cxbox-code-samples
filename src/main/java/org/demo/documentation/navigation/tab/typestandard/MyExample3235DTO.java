package org.demo.documentation.navigation.tab.typestandard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3235DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample3235DTO(MyEntity3235 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}