package org.demo.documentation.widgets.tree.showcondition.byparententity.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3276DTO extends DataResponseDTO {
	public static final String TEXT = "The \"Show parent/child condition\" functionality is not working for the list widget.. Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

	public static final String TEXT2 = "Show condition - if CustomFieldNumber  > 5 widget show.";

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
	private Long customFieldNumber;
	private boolean customFieldShowCondition;

	private Boolean isLeaf;

	@SearchParameter(name = "parentId")
	private String parentId;

	@SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldMoney;

	@SearchParameter(name = "parentTreeId")
	private String parentTreeId;

	public MyExample3276DTO(MyEntity3276 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldNumber = entity.getCustomFieldNumber();
		this.customFieldShowCondition = entity.getCustomFieldNumber() > 5;

		this.parentId = entity.getParentId();
		this.customFieldMoney = entity.getCustomFieldMoney();
		this.parentTreeId = entity.getParentTreeId();
	}
}