package org.demo.documentation.widgets.tree.actions.create.withwidget;

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
public class MyExample3279DTO extends DataResponseDTO {

	private String customField;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;

	@SearchParameter(name = "isLeaf", provider = StringValueProvider.class)
	private String isLeaf;

	@SearchParameter(name = "parentId", provider = StringValueProvider.class)
	private String parentId;

	@SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldMoney;

	public MyExample3279DTO(MyEntity3279 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();
		this.isLeaf = entity.getIsLeaf();
		this.parentId = entity.getParentId();
		this.customFieldMoney = entity.getCustomFieldMoney();
	}
}