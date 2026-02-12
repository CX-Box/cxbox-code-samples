package org.demo.documentation.widgets.assoc.actions.other.buttonassoc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3062MultiMultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3062MultiMultivalueDTO(MyEntity3062Multi entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
