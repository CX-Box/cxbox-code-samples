package org.demo.documentation.widgets.form.colortitle.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3038MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3038MultivalueDTO(org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3038 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
