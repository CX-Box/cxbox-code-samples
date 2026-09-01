package org.demo.documentation.widgets.tree.colortitle.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Multi;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3267MultiMultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3267MultiMultivalueDTO(Myexample3262Multi entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
