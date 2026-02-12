package org.demo.documentation.fields.suggestion.validationannotation.forfield;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

import static org.demo.documentation.fields.main.TextError.ONLY_LETTER;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3111DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	@Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
	private String customField;

	public MyExample3111DTO(MyEntity3111 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}