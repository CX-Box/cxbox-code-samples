package org.demo.documentation.fields.suggestion.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3085SuggestionDTO extends DataResponseDTO {

	private String customFieldSuggestion;
	private LocalDateTime customFieldSuggestionDate;

	public MyExample3085SuggestionDTO(MyEntity3085OutServiceDTO entity) {
		this.id = entity.getId().toString();
		this.customFieldSuggestion = entity.getCustomFieldSuggestion();
		this.customFieldSuggestionDate = entity.getCustomFieldSuggestionDate();
	}
}