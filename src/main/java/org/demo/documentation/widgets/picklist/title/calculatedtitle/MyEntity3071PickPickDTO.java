package org.demo.documentation.widgets.picklist.title.calculatedtitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3071PickPickDTO extends DataResponseDTO {

	private String customFieldPick;

	public MyEntity3071PickPickDTO(MyEntity3071Pick entity) {
		this.id = entity.getId().toString();
		this.customFieldPick = entity.getCustomFieldPick();
	}

}
