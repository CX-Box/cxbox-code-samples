package org.demo.documentation.widgets.property.showcondition.twobcshowcondition.parent;

import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3146DTO extends DataResponseDTO {

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	private Boolean isLeaf;

	public static final String INFO_TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

	private Boolean customFieldShowCondition;
	@SearchParameter(name = "customField")
	private Long customField;

	public MyExample3146DTO(MyEntity3146 entity) {
		this.id = entity.getId().toString();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
		this.customFieldShowCondition = entity.getCustomField() > 5;
		this.customField = entity.getCustomField();
	}
}