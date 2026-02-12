package org.demo.documentation.widgets.list.showcondition.byparententity.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3100DTO extends DataResponseDTO {
	public static final String TEXT = "The \"Show parent/child condition\" functionality is not working for the list widget.. Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

	public static final String TEXT2 = "Show condition - if CustomFieldNumber  > 5 widget show.";

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
	private Long customFieldNumber;
	private boolean customFieldShowCondition;

	public MyExample3100DTO(MyEntity3100 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldNumber = entity.getCustomFieldNumber();
		this.customFieldShowCondition = entity.getCustomFieldNumber() > 5;
	}
}