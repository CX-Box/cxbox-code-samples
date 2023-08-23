package org.demo.documentation.picklist.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity125PickDTO extends DataResponseDTO {

	private String customField;

	@SearchParameter(name = "customFieldAdditional")
	private String customFieldAdditional;

	public MyEntity125PickDTO(MyEntity125 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldAdditional = entity.getCustomFieldAdditional();
	}

}
