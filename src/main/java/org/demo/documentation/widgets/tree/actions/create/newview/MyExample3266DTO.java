package org.demo.documentation.widgets.tree.actions.create.newview;

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
public class MyExample3266DTO extends DataResponseDTO {
	public static final String INFO_TEXT = "Tree widget is list the general information for many records and present it in a way that is easily interpretable for users.";

	private String customField;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;

	@SearchParameter(name = "isLeaf", provider = StringValueProvider.class)
	private String isLeaf;

	@SearchParameter(name = "parentId", provider = StringValueProvider.class)
	private String parentId;

	@SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldMoney;

	public MyExample3266DTO(MyEntity3266 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();
		this.isLeaf = entity.getIsLeaf();
		this.parentId = entity.getParentId();
		this.customFieldMoney = entity.getCustomFieldMoney();
	}
}