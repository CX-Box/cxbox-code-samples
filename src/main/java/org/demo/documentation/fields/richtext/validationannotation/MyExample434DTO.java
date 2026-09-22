package org.demo.documentation.fields.richtext.validationannotation;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

import static org.demo.documentation.fields.main.TextError.MAX_50_CHARACTERS;

@Getter
@Setter
@NoArgsConstructor
public class MyExample434DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	@Size(max = 50, message = MAX_50_CHARACTERS)
	private String customField;

	public MyExample434DTO(MyEntity434 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}