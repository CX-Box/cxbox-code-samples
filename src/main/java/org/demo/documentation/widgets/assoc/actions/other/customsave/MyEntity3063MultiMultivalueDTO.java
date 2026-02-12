package org.demo.documentation.widgets.assoc.actions.other.customsave;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3063MultiMultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3063MultiMultivalueDTO(MyEntity3063Multi entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
