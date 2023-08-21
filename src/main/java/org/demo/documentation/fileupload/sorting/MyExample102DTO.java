package org.demo.documentation.fileupload.sorting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample102DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "customFieldId")
	private String customFieldId;

	public MyExample102DTO(MyEntity102 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldId = entity.getCustomFieldId();
	}

}