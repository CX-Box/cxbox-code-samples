package org.demo.documentation.widgets.form.actions.cancelcreate.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3182DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample3182DTO(MyEntity3182 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}