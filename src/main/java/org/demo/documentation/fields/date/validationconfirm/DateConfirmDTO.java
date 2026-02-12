package org.demo.documentation.fields.date.validationconfirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DateConfirmDTO extends DataResponseDTO {

	private LocalDateTime customField;

	public DateConfirmDTO(DateConfirmEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}