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
	public static final String INFO_TEXT = "Info widget is a component only for data viewing";

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample3001DTO(MyEntity3001 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}