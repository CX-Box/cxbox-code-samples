package org.demo.documentation.fields.radio.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.fields.radio.validationdynamic.enums.CustomFieldAdditionalEnum;
import org.demo.documentation.fields.radio.validationdynamic.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample340DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	private CustomFieldEnum customField;

	@SearchParameter(name = "customFieldAdditional", provider = EnumValueProvider.class)
	private CustomFieldAdditionalEnum customFieldAdditional;

	public MyExample340DTO(MyEntity340 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldAdditional = entity.getCustomFieldAdditional();
	}

}