package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forpicklist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3862PickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3862PickPickDTO(MyEntity3862Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
