package org.demo.documentation.other.forceactive.example3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3207DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldCheckBox", provider = BooleanValueProvider.class)
	private Boolean customFieldCheckBox;

	public MyExample3207DTO(MyEntity3207 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldCheckBox = entity.getCustomFieldCheckBox();
	}
}