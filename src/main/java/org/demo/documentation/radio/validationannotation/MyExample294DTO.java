package org.demo.documentation.radio.validationannotation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.radio.validationannotation.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample294DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	@NotNull(message = "Custom message about error")
	private CustomFieldEnum customField;

	public MyExample294DTO(MyEntity294 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}