package org.demo.documentation.widgets.assoctree.colortitle.color;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.demo.documentation.widgets.assoctree.colortitle.MyEntity3332Multi;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3332MultiPickDTO extends DataResponseDTO {

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	private Boolean isLeaf;
	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;
	private String customFieldColor;
	private String customFieldColorFieldText;

	public MyEntity3332MultiPickDTO(MyEntity3332Multi entity) {
		this.id = entity.getId().toString();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();
		this.customFieldColor = "#eda6a6";
		this.customFieldColorFieldText = "#a6eda6";
	}

}
