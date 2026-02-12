package org.demo.documentation.fields.suggestion.validationannotation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3110SuggestionDTO extends DataResponseDTO {

	private String customFieldSuggestion;
	private LocalDateTime customFieldSuggestionDate;

	public MyExample3110SuggestionDTO(MyEntity3110OutServiceDTO entity) {
		this.id = entity.getId().toString();
		this.customFieldSuggestion = entity.getCustomFieldSuggestion();
		this.customFieldSuggestionDate = entity.getCustomFieldSuggestionDate();

	}
}