package org.demo.documentation.radio.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.radio.drilldown.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample24DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	private CustomFieldEnum customField;

	public MyExample24DTO(MyEntity24 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}