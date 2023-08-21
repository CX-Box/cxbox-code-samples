package org.demo.documentation.dateytimewithseconds.validationruntimeex;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsValidationRuntimeExEntityDTO extends DataResponseDTO {

	private LocalDateTime customField;

	public DateTimeWithSecondsValidationRuntimeExEntityDTO(DateTimeWithSecondsValidationRuntimeExEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}