package org.demo.documentation.fields.datetimewithseconds.sorting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsSortingDTO extends DataResponseDTO {

	private LocalDateTime customField;

	public DateTimeWithSecondsSortingDTO(DateTimeWithSecondsSortingEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}