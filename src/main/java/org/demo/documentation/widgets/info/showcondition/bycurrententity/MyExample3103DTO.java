package org.demo.documentation.widgets.info.showcondition.bycurrententity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3103DTO extends DataResponseDTO {

	public static final String TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

	public static final String TEXT2 = "Show condition - if CustomField  > 5 widget show.";
	@SearchParameter(name = "customField")
	private Long customField;

	private String customFieldShowCond;

	public MyExample3103DTO(MyEntity3103 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldShowCond = entity.getCustomField() > 5 ? "true" : "false";
	}
}