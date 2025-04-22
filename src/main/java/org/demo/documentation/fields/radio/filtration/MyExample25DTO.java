package org.demo.documentation.fields.radio.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.fields.radio.filtration.enums.CustomFieldEnum;
import org.demo.documentation.fields.radio.filtration.enums.CustomFieldNewEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample25DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	private CustomFieldEnum customField;
	@SearchParameter(name = "customFieldNew", provider = EnumValueProvider.class)
	private CustomFieldNewEnum customFieldNew;

	public MyExample25DTO(MyEntity25 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldNew = entity.getCustomFieldNew();
	}

}