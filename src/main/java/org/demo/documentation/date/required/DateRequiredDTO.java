package org.demo.documentation.date.required;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class DateRequiredDTO extends DataResponseDTO {

	private LocalDate customField;

	public DateRequiredDTO(DateRequiredEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}