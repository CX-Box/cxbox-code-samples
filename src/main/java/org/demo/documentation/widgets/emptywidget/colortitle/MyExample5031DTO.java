package org.demo.documentation.widgets.emptywidget.colortitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5031DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = StringValueProvider.class)
	private String customField;

	// --8<-- [start:colorDTO]
	private String customFieldColor;
	private String customFieldTextColor;

	@SearchParameter(name = "customFieldText", provider = StringValueProvider.class)
	private String customFieldText;

	public MyExample5031DTO(MyEntity5031 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();

		this.customFieldColor = "#eda6a6";
		this.customFieldTextColor = "#a6eda6";
	}
	// --8<-- [end:colorDTO]
}
