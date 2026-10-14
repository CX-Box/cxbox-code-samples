package org.demo.documentation.widgets.tree.colortitle.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Multi;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3267MultiMultivalueDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	private Boolean isLeaf;

	public MyEntity3267MultiMultivalueDTO(Myexample3262Multi entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
	}

}
