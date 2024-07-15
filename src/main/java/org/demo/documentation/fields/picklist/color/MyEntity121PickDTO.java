package org.demo.documentation.fields.picklist.color;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity121PickDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	private String customFieldColor;

	public MyEntity121PickDTO(MyEntity121 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldColor = "#eda6a6";
	}

}
