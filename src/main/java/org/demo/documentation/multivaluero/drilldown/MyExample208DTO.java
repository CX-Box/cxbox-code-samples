package org.demo.documentation.multivaluero.drilldown;

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
public class MyExample208DTO extends DataResponseDTO {

	@SearchParameter(name = "customField.customField", multiFieldKey = MultiFieldValueProvider.class)
	private MultivalueField customField;

	public MyExample208DTO(MyEntity208 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomFieldList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity209::getCustomField
		));
	}

}