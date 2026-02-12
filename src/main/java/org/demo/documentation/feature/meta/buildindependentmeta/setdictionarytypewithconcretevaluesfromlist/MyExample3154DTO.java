package org.demo.documentation.feature.meta.buildindependentmeta.setdictionarytypewithconcretevaluesfromlist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3154DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample3154DTO(MyEntity3154 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}