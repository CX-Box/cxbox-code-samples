package org.demo.documentation.fields.radio.color;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.fields.radio.color.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample21DTO extends DataResponseDTO {

	private String customFieldColor;

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	private CustomFieldEnum customField;

	public MyExample21DTO(MyEntity21 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldColor = "#eda6a6";
	}

}