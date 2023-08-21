package org.demo.documentation.text.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample45DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample45DTO(MyEntity45 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}