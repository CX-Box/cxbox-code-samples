package org.demo.documentation.widgets.assoctree.actions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3331MultiMultivalueDTO extends DataResponseDTO {

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	private Boolean isLeaf;

	@SearchParameter(name = "customField")
	private String customField;

	public MyEntity3331MultiMultivalueDTO(MyEntity3331Multi entity) {
		this.id = entity.getId().toString();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
		this.customField = entity.getCustomField();
	}

}
