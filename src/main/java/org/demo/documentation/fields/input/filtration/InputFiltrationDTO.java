package org.demo.documentation.fields.input.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class InputFiltrationDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "brand")
	private String brand;

	public InputFiltrationDTO(InputFiltration entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.brand = entity.getBrand();
	}

}