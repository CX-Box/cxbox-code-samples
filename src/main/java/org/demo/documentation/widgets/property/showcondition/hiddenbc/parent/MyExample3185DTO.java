package org.demo.documentation.widgets.property.showcondition.hiddenbc.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3185DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldCheckbox", provider = BooleanValueProvider.class)
	private Boolean customFieldCheckbox;

	public MyExample3185DTO(MyEntity3185 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldCheckbox = entity.getCustomFieldCheckbox();
	}
}