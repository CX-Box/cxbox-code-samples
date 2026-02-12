package org.demo.documentation.screen.withouticon;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5001DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample5001DTO(MyEntity5001 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}
