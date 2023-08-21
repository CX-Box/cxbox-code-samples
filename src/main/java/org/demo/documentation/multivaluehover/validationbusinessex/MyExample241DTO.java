package org.demo.documentation.multivaluehover.validationbusinessex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.MultiFieldValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample241DTO extends DataResponseDTO {

	@SearchParameter(name = "customField.customField", multiFieldKey = MultiFieldValueProvider.class)
	private MultivalueField customField;

	public MyExample241DTO(MyEntity241 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomFieldList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity242::getCustomField
		));
	}

}