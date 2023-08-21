package org.demo.documentation.hint.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample156DTO extends DataResponseDTO {

	private String customField;

	@SearchParameter(name = "textField")
	private String textField;

	public MyExample156DTO(MyEntity156 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.textField = entity.getTextField();
	}

}