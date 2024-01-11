package org.demo.documentation.widgets.info.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3001DTO extends DataResponseDTO {
	public static final String INFO_TEXT = "List widget is list the general information for many records and present it in a way that is easily interpretable for users.";

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample3001DTO(MyEntity3001 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}