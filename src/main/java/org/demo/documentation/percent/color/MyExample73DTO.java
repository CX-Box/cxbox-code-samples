package org.demo.documentation.percent.color;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample73DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = BigDecimalValueProvider.class)
	private Long customField;

	private String customFieldColor;

	public MyExample73DTO(MyEntity73 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldColor = "#eda6a6";
	}

}