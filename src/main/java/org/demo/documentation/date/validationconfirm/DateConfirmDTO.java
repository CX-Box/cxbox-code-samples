package org.demo.documentation.date.validationconfirm;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class DateConfirmDTO extends DataResponseDTO {

	private LocalDate customField;

	public DateConfirmDTO(DateConfirmEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}