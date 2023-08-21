package org.demo.documentation.number.ro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class NumberCreateEditDTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = BigDecimalValueProvider.class)
	private Long customField;

	public NumberCreateEditDTO(NumberCreateEditEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}