package org.demo.documentation.widgets.property.defaultlimitpage.forpick;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity359PickPickDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	private Boolean isLeaf;

	public MyEntity359PickPickDTO(MyEntity359Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
	}

}
