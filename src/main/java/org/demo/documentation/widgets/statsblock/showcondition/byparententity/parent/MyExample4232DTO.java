package org.demo.documentation.widgets.statsblock.showcondition.byparententity.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4232DTO extends DataResponseDTO {

	public static final String TEXT = "Condition can include boolean expression depending on parent entity. Parent field updates will trigger condition recalculation only on save or if field is force active shown on same view";

	public static final String TEXT2 = "Show condition - if Custom Field Number > 5 widget show.";

	private Long customFieldNumber;

	private boolean customFieldShowCondition;

	public MyExample4232DTO(MyEntity4232 entity) {
		this.id = entity.getId().toString();
		this.customFieldNumber = entity.getCustomFieldNumber();
		this.customFieldShowCondition = entity.getCustomFieldNumber() != null && entity.getCustomFieldNumber() > 5;
	}

}
