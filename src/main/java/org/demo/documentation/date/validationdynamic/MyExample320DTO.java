package org.demo.documentation.date.validationdynamic;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample320DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = DateValueProvider.class)
	private LocalDate customField;

	@SearchParameter(name = "customFieldAdditional", provider = DateValueProvider.class)
	private LocalDate customFieldAdditional;

	public MyExample320DTO(MyEntity320 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldAdditional = entity.getCustomFieldAdditional();
	}

}