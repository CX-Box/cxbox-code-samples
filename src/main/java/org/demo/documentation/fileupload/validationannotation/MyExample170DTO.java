package org.demo.documentation.fileupload.validationannotation;

import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample170DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	@Pattern(regexp = "[A-Za-z]+", message = "The field  can contain only letters.")
	private String customField;

	@SearchParameter(name = "customFieldId")
	private String customFieldId;

	public MyExample170DTO(MyEntity170 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldId = entity.getCustomFieldId();
	}

}