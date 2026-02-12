package org.demo.documentation.fields.suggestion.color.colorconst;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3083SuggestionDTO extends DataResponseDTO {

	private String customFieldSuggestion;
	private LocalDateTime customFieldSuggestionDate;

	public MyExample3083SuggestionDTO(MyEntity3083OutServiceDTO entity) {
		this.id = entity.getId().toString();
		this.customFieldSuggestion = entity.getCustomFieldSuggestion();
		this.customFieldSuggestionDate = entity.getCustomFieldSuggestionDate();
	}
}