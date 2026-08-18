package org.demo.documentation.widgets.tree.showcondition.bycurrententity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3269DTO extends DataResponseDTO {
	public static final String TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

	public static final String TEXT2 = "Show condition - if CustomField  > 5 widget show.";

	private Long customField;
	private String customFieldShowCond;

	public MyExample3269DTO(MyEntity3269 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldShowCond = entity.getCustomField() > 5 ? "true" : "false";
	}
}