package org.demo.documentation.widgets.tree.showcondition.byparententity.child;

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
public class MyExample3277DTO extends DataResponseDTO {

	public static final String TEXT = "Condition can include boolean expression depending on parent entity. Parent field updates will trigger condition recalculation only on save or if field is force active shown on same view";

	private Boolean customFieldShowCondition;
	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
	private Long customFieldNumber;

	private Boolean isLeaf;


	@SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldMoney;

	@SearchParameter(name = "parentTreeId")
	private String parentTreeId;

	public MyExample3277DTO(MyEntity3277 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldNumber = entity.getCustomFieldNumber();
		this.customFieldShowCondition = entity.getCustomFieldNumber() > 5;
		this.isLeaf = entity.getParentTreeId() == null ? false : true;

		this.customFieldMoney = entity.getCustomFieldMoney();
		this.parentTreeId = entity.getParentTreeId();
	}
}