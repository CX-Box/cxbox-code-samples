package org.demo.documentation.radio.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.radio.filtration.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample25DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	private CustomFieldEnum customField;

	public MyExample25DTO(MyEntity25 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}