package org.demo.documentation.widgets.steps.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5023DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	private StepsEnum editStep;
	private String description;

	public MyExample5023DTO(MyEntity5023 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.editStep = entity.getEditStep();
		this.description = entity.getEditStep().getDescription();
	}
}
