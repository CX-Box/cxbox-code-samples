package org.demo.documentation.fields.number.additionalproperties.digits;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class DigitsNumberDTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = BigDecimalValueProvider.class)
	private Double customField;

	public DigitsNumberDTO(DigitsNumberEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}