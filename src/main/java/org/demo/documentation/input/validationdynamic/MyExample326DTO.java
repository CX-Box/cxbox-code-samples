package org.demo.documentation.input.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample326DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = StringValueProvider.class)
	private String customField;

	@SearchParameter(name = "customFieldAdditional", provider = StringValueProvider.class)
	private String customFieldAdditional;

	public MyExample326DTO(MyEntity326 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldAdditional = entity.getCustomFieldAdditional();
	}

}