package org.demo.documentation.widgets.pie1d.showcondition.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4215ParentDTO extends DataResponseDTO {

	private Long customFieldNumber;

	private boolean customFieldShowCondition;

	public MyExample4215ParentDTO(MyEntity4215Parent entity) {
		this.id = entity.getId().toString();
		this.customFieldNumber = entity.getCustomFieldNumber();
		this.customFieldShowCondition = entity.getCustomFieldNumber() != null && entity.getCustomFieldNumber() > 5;
	}

}
