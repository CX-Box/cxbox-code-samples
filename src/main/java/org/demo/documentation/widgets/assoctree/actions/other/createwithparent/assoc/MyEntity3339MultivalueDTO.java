package org.demo.documentation.widgets.assoctree.actions.other.createwithparent.assoc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;


@Getter
@Setter
@NoArgsConstructor
public class MyEntity3339MultivalueDTO extends DataResponseDTO {

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	private Boolean isLeaf;

	private String customField;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;

	public MyEntity3339MultivalueDTO(MyEntity3339 entity) {
		this.id = entity.getId().toString();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();
	}

}
