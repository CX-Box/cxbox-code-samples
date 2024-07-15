package org.demo.documentation.fields.dictionary.validationannotationcustom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.fields.dictionary.validationannotationcustom.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample169DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	@CustomerTypeSubset(anyOf = {CustomFieldEnum.HIGH, CustomFieldEnum.MIDDLE},
			message = "The field  can contain any of 'High,Middle'")
	private CustomFieldEnum customField;

	public MyExample169DTO(MyEntity169 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}