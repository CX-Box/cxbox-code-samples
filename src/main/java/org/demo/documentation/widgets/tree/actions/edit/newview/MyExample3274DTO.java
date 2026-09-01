package org.demo.documentation.widgets.tree.actions.edit.newview;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3274DTO extends DataResponseDTO {

	private String customField;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;

	private Boolean isLeaf;

	@SearchParameter(name = "parentId")
	private String parentId;

	@SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldMoney;

	public MyExample3274DTO(MyEntity3274 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();

		this.isLeaf = entity.getParentId() != null;
		this.parentId = entity.getParentId();
		this.customFieldMoney = entity.getCustomFieldMoney();
	}
}