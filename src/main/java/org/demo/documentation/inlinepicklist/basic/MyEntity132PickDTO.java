package org.demo.documentation.inlinepicklist.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
// --8<-- [start:Basics]
public class MyEntity132PickDTO extends DataResponseDTO {

	@SearchParameter
	private String customField;

	public MyEntity132PickDTO(org.demo.documentation.inlinepicklist.basic.picklist.MyEntity132 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
// --8<-- [end:Basics]