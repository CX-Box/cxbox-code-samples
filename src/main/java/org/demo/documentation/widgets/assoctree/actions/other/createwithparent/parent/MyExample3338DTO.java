package org.demo.documentation.widgets.assoctree.actions.other.createwithparent.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3338DTO extends DataResponseDTO {

	private String customField;

	public MyExample3338DTO(MyEntity3338 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}