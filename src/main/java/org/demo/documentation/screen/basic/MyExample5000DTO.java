package org.demo.documentation.screen.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5000DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "editStep")
	private String editStep;

	public MyExample5000DTO(MyEntity5000 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.editStep = entity.getEditStep();
	}
}
