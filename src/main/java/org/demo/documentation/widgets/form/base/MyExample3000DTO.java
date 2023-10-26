package org.demo.documentation.widgets.form.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3000DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample3000DTO(MyEntity3000 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}