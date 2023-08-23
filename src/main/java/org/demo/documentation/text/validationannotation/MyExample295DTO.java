package org.demo.documentation.text.validationannotation;

import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample295DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	@Pattern(regexp = "[A-Za-z]+", message = "The field 'customField' can contain only letters.")
	private String customField;

	public MyExample295DTO(MyEntity295 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}