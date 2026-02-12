package org.demo.documentation.widgets.form.actions.save;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3181DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample3181DTO(MyEntity3181 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}