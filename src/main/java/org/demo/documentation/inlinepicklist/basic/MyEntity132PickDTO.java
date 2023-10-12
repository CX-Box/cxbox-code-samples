package org.demo.documentation.inlinepicklist.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor

public class MyEntity132PickDTO extends DataResponseDTO {

	@SearchParameter
	private String customField;

	public MyEntity132PickDTO(MyEntity132Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
