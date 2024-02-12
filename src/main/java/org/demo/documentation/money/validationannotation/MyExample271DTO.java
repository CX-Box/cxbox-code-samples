package org.demo.documentation.money.validationannotation;

import javax.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

import static org.demo.documentation.main.TextError.LESS_100000;


@Getter
@Setter
@NoArgsConstructor
public class MyExample271DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = BigDecimalValueProvider.class)
	@DecimalMin(value = "100000.00", message = LESS_100000)
	private Double customField;

	public MyExample271DTO(MyEntity271 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}