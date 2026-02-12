package org.demo.documentation.widgets.formpopup.colortitle.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3042MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3042MultivalueDTO(org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3042 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
