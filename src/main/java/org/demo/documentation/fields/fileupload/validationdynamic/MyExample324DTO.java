package org.demo.documentation.fields.fileupload.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample324DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "customFieldId")
	private String customFieldId;

	@SearchParameter(name = "customFieldAdditional")
	private String customFieldAdditional;

	@SearchParameter(name = "customFieldAdditionalId")
	private String customFieldAdditionalId;

	public MyExample324DTO(MyEntity324 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldId = entity.getCustomFieldId();
		this.customFieldAdditional = entity.getCustomFieldAdditional();
		this.customFieldAdditionalId = entity.getCustomFieldAdditionalId();
	}

}