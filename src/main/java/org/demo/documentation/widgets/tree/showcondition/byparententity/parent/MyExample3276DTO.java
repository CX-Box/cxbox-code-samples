package org.demo.documentation.widgets.tree.showcondition.byparententity.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

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

	@SearchParameter(name = "isLeaf", provider = StringValueProvider.class)
	private String isLeaf;

	@SearchParameter(name = "parentId", provider = StringValueProvider.class)
	private String parentId;

	@SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldMoney;

	@SearchParameter(name = "parentTreeId", provider = StringValueProvider.class)
	private String parentTreeId;

	public MyExample3276DTO(MyEntity3276 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldNumber = entity.getCustomFieldNumber();
		this.customFieldShowCondition = entity.getCustomFieldNumber() > 5;
		this.isLeaf = entity.getIsLeaf();
		this.parentId = entity.getParentId();
		this.customFieldMoney = entity.getCustomFieldMoney();
		this.parentTreeId = entity.getParentTreeId();
	}
}