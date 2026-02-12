package org.demo.documentation.feature.meta.buildrowdependentmeta;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3153DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample3153DTO(MyEntity3153 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}