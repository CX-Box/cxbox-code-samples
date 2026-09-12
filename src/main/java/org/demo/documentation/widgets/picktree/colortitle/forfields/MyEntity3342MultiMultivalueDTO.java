package org.demo.documentation.widgets.picktree.colortitle.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3342MultiMultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3342MultiMultivalueDTO(org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342Multi entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
