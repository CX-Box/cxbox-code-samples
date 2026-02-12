package org.demo.documentation.widgets.headerwidget.colortitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5024DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "customFieldText")
	private String customFieldText;

	// --8<-- [start:colorDTO]
	private String customFieldColor;
	private String customFieldTextColor;

	public MyExample5024DTO(MyEntity5024 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();
		this.customFieldColor = "#eda6a6";
		this.customFieldTextColor = "#a6eda6";
	}
	// --8<-- [end:colorDTO]
}
