package org.demo.documentation.widgets.tree.actions.edit.newview;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3274DTO extends DataResponseDTO {

	private String customField;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;

	public MyExample3274DTO(MyEntity3274 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();
	}
}