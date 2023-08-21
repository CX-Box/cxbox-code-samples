package org.demo.documentation.dictionary.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.dictionary.validationdynamic.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample323DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	private CustomFieldEnum customField;

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	private CustomFieldEnum customFieldAdditional;

	public MyExample323DTO(MyEntity323 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldAdditional = entity.getCustomFieldAdditional();
	}

}