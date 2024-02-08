package org.demo.documentation.checkbox.validationannotation;

import javax.validation.constraints.AssertTrue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample168DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = BooleanValueProvider.class)
	@AssertTrue(message = "The field  can contain only 'True'")
	private Boolean customField;

	public MyExample168DTO(MyEntity168 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}