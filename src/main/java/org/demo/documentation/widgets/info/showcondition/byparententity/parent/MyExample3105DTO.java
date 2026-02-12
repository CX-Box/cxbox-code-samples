package org.demo.documentation.widgets.info.showcondition.byparententity.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3105DTO extends DataResponseDTO {
	public static final String INFO_TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

	public static final String INFO_TEXT2 = "Show condition child widget  - if CustomField  > 5 widget show.";

	private Boolean customFieldShowCondition;

	@SearchParameter(name = "customField", provider = BigDecimalValueProvider.class)
	private Long customField;

	public MyExample3105DTO(MyEntity3105 entity) {
		this.id = entity.getId().toString();
		this.customFieldShowCondition = entity.getCustomField() > 5;
		this.customField = entity.getCustomField();
	}
}