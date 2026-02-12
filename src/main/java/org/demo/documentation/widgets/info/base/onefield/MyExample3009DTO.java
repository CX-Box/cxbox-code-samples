package org.demo.documentation.widgets.info.base.onefield;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3009DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;

	public MyExample3009DTO(MyEntity3009 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();
	}
}