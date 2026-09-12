package org.demo.documentation.widgets.assoctree.base.forfield;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;


@Getter
@Setter
@NoArgsConstructor
public class MyEntity3330MultiMultivalueDTO extends DataResponseDTO {

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	private Boolean isLeaf;

	private String customField;
	@SearchParameter(name = "customFieldNew")
	private String customFieldNew;

	public MyEntity3330MultiMultivalueDTO(MyEntity3330Multi entity) {
		this.id = entity.getId().toString();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
		this.customField = entity.getCustomField();
		this.customFieldNew = entity.getCustomFieldNew();
	}

}
