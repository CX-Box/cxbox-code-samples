package org.demo.documentation.fields.input.validationannotation;

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
public class MyExample163DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	@Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
	private String customField;

	public MyExample163DTO(MyEntity163 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}