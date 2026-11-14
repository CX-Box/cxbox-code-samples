package org.demo.documentation.feature.file.availability;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.feature.file.availability.enums.StatusEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample6104DTO extends DataResponseDTO {

	private String customField;

	private StatusEnum status;

	public MyExample6104DTO(MyEntity6104 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.status = entity.getStatus();
	}
}
