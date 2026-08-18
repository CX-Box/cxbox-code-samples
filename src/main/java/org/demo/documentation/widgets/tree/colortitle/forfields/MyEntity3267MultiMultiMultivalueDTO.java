package org.demo.documentation.widgets.tree.colortitle.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3267MultiMultiMultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3267MultiMultiMultivalueDTO(org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267MultiMulti entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
