package org.demo.documentation.widgets.cardcarousellist.showcondition.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5063DTO extends DataResponseDTO {

	private Long customFieldNumber;

	// --8<-- [start:customFieldShowCondition]
	private boolean customFieldShowCondition;
	// --8<-- [end:customFieldShowCondition]

	public MyExample5063DTO(MyEntity5063 entity) {
		this.id = entity.getId().toString();
		this.customFieldNumber = entity.getCustomFieldNumber();
		this.customFieldShowCondition = entity.getCustomFieldNumber() != null && entity.getCustomFieldNumber() > 5;
	}

}
