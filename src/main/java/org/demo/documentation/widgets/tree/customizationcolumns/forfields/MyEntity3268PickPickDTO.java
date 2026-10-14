package org.demo.documentation.widgets.tree.customizationcolumns.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Pick;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3268PickPickDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	private Boolean isLeaf;

	public MyEntity3268PickPickDTO(Myexample3262Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
	}

}
