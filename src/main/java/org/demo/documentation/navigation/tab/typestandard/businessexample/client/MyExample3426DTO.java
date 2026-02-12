package org.demo.documentation.navigation.tab.typestandard.businessexample.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3426DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "address")
	private String address;

	public MyExample3426DTO(MyEntity3426 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.address = entity.getAddress();
	}
}