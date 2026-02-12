package org.demo.documentation.other.savewithparent.example3.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3425DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample3425DTO(MyEntity3425 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}