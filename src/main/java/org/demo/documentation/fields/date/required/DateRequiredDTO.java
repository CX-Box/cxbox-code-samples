package org.demo.documentation.fields.date.required;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class DateRequiredDTO extends DataResponseDTO {

	private LocalDateTime  customField;

	public DateRequiredDTO(DateRequiredEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}