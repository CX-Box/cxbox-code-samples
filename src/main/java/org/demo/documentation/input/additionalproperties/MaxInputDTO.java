package org.demo.documentation.input.additionalproperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MaxInputDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MaxInputDTO(MaxInputEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}