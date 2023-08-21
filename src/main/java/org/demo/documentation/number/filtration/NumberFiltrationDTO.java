package org.demo.documentation.number.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class NumberFiltrationDTO extends DataResponseDTO {


	@SearchParameter(name = "customField", provider = BigDecimalValueProvider.class)
	private Long customField;

	public NumberFiltrationDTO(NumberFiltrationEntity entity) {
		this.id = entity.getId().toString();

		this.customField = entity.getCustomField();
	}

}