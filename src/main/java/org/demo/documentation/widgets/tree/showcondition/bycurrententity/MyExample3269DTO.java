package org.demo.documentation.widgets.tree.showcondition.bycurrententity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3269DTO extends DataResponseDTO {
	public static final String TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

	public static final String TEXT2 = "Show condition - if CustomField  > 5 widget show.";

	private Long customField;
	private String customFieldShowCond;


	@SearchParameter(name = "customFieldInput", provider = StringValueProvider.class)
	private String customFieldInput;

	@SearchParameter(name = "isLeaf", provider = StringValueProvider.class)
	private String isLeaf;

	@SearchParameter(name = "parentId", provider = StringValueProvider.class)
	private String parentId;

	public MyExample3269DTO(MyEntity3269 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldShowCond = entity.getCustomField() > 5 ? "true" : "false";
		this.customFieldInput = entity.getCustomFieldInput();

		this.isLeaf = entity.getIsLeaf();
		this.parentId = entity.getParentId();
	}
}