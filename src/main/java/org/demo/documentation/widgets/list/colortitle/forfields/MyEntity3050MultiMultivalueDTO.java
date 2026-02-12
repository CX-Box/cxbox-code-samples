package org.demo.documentation.widgets.list.colortitle.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3050MultiMultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3050MultiMultivalueDTO(org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050Multi entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
