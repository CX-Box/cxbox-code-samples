package org.demo.documentation.fields.suggestion.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3117SuggestionDTO extends DataResponseDTO {
	private String customFieldSuggestion;
	private LocalDateTime customFieldSuggestionDate;

	public MyExample3117SuggestionDTO(MyEntity3117OutServiceDTO entity) {

		this.id = entity.getId().toString();
		this.customFieldSuggestion = entity.getCustomFieldSuggestion();
		this.customFieldSuggestionDate = entity.getCustomFieldSuggestionDate();
	}
}