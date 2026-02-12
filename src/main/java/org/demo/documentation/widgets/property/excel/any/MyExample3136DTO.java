package org.demo.documentation.widgets.property.excel.any;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3136DTO extends DataResponseDTO {

	private String customField;
	private LocalDateTime customFieldDateTime;

	public MyExample3136DTO(MyEntity3136OutServiceDTO entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldDateTime = entity.getCustomFieldDateTime();
	}
}