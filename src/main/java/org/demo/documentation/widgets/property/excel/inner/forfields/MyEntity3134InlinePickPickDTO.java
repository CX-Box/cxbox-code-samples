package org.demo.documentation.widgets.property.excel.inner.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3134InlinePickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3134InlinePickPickDTO(MyEntity3134InlinePick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
