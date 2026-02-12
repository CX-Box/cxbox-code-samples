package org.demo.documentation.widgets.form.actions.create.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3300DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample3300DTO(MyEntity3300 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}