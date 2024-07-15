package org.demo.documentation.fields.dictionary.validationruntimeex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.fields.dictionary.validationruntimeex.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample93DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	private CustomFieldEnum customField;

	public MyExample93DTO(MyEntity93 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}