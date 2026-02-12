package org.demo.documentation.fields.datetimewithseconds.validationconfirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsValidationBusinessExDTO extends DataResponseDTO {

	private LocalDateTime customField;

	public DateTimeWithSecondsValidationBusinessExDTO(DateTimeWithSecondsValidationBusinessExEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}