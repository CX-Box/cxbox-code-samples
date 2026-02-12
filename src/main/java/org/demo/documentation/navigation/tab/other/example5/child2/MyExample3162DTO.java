package org.demo.documentation.navigation.tab.other.example5.child2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3162DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample3162DTO(MyEntity3162 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}