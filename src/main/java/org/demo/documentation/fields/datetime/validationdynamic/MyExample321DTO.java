package org.demo.documentation.fields.datetime.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateTimeValueProvider;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample321DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = DateTimeValueProvider.class)
	private LocalDateTime customField;

	@SearchParameter(name = "customFieldAdditional", provider = DateTimeValueProvider.class)
	private LocalDateTime customFieldAdditional;

	public MyExample321DTO(MyEntity321 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldAdditional = entity.getCustomFieldAdditional();
	}

}