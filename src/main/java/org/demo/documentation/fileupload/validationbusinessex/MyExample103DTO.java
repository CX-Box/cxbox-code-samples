package org.demo.documentation.fileupload.validationbusinessex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample103DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "customFieldId")
	private String customFieldId;

	public MyExample103DTO(MyEntity103 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldId = entity.getCustomFieldId();
	}

}