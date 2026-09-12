package org.demo.documentation.widgets.assoctree.customizationcolumns;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;


@Getter
@Setter
@NoArgsConstructor
public class MyEntity3335AssocPickDTO extends DataResponseDTO {

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	private Boolean isLeaf;

	private String customField;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;
	@SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
	private Long customFieldNumber;

	public MyEntity3335AssocPickDTO(MyEntity3335Assoc entity) {
		this.id = entity.getId().toString();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();
		this.customFieldNumber = entity.getCustomFieldNumber();
	}

}
