package org.demo.documentation.widgets.formpopup.colortitle.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3041MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3041MultivalueDTO(org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3041 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
