package org.demo.documentation.widgets.picklist.title.withtitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3068PickPickDTO extends DataResponseDTO {

	private String customFieldPick;

	public MyEntity3068PickPickDTO(MyEntity3068Pick entity) {
		this.id = entity.getId().toString();
		this.customFieldPick = entity.getCustomFieldPick();
	}

}
