package org.demo.documentation.fileupload.color;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample95DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "customFieldId")
	private String customFieldId;

	private String customFieldColor;

	public MyExample95DTO(MyEntity95 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldId = entity.getCustomFieldId();
		this.customFieldColor = "#eda6a6";
	}

}