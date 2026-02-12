package org.demo.documentation.widgets.form.actions.edit.withview;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3303DTO extends DataResponseDTO {

	public static final String INFO_TEXT = "With Edit with view, you can edit the entity from a separate view that displays only the data entry form. Click on the \"Edit\" option.";

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;

	public MyExample3303DTO(MyEntity3303 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();
	}
}