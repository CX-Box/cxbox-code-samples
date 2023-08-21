package org.demo.documentation.money.sorting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;


@Getter
@Setter
@NoArgsConstructor
public class MyExample66DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = BigDecimalValueProvider.class)
	private Double customField;

	public MyExample66DTO(MyEntity66 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}