package org.demo.documentation.widgets.additionallist.title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3195DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;

	public MyExample3195DTO(MyEntity3195 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();
	}
}