package org.demo.documentation.widgets.property.showcondition.twobcshowcondition.child;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3145DTO extends DataResponseDTO {

	private String customField;

	public MyExample3145DTO(MyEntity3145 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}