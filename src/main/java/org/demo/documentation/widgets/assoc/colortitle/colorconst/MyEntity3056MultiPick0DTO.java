package org.demo.documentation.widgets.assoc.colortitle.colorconst;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.demo.documentation.widgets.assoc.colortitle.MyEntity3056Multi;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3056MultiPick0DTO extends DataResponseDTO {
	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;

	public MyEntity3056MultiPick0DTO(MyEntity3056Multi entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();

	}

}
