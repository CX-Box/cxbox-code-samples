package org.demo.documentation.fields.suggestion.ro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3088SuggestionDTO extends DataResponseDTO {

	private String customFieldSuggestion;
	private LocalDateTime customFieldSuggestionDate;

	public MyExample3088SuggestionDTO(MyEntity3088OutServiceDTO entity) {

		this.id = entity.getId().toString();
		this.customFieldSuggestion = entity.getCustomFieldSuggestion();
		this.customFieldSuggestionDate = entity.getCustomFieldSuggestionDate();
	}
}