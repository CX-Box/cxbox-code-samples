package org.demo.documentation.fields.fileupload.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample100DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "customFieldId")
	private String customFieldId;

	private String customFieldRO;

	private String customFieldROId;

	public MyExample100DTO(MyEntity100 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldId = entity.getCustomFieldId();
		this.customFieldRO = entity.getCustomFieldRO();
		this.customFieldROId = entity.getCustomFieldROId();
	}

}