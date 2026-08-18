package org.demo.documentation.widgets.tree.actions.edit.withwidget;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3275DTO extends DataResponseDTO {
	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;

	public MyExample3275DTO(MyEntity3275 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();
	}
}