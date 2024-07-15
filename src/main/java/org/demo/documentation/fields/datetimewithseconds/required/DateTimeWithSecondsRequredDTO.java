package org.demo.documentation.fields.datetimewithseconds.required;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsRequredDTO extends DataResponseDTO {

	private LocalDateTime customField;

	public DateTimeWithSecondsRequredDTO(DateTimeWithSecondsRequredEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}