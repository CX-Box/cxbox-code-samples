package org.demo.documentation.widgets.formpopup.required;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3403DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = StringValueProvider.class)
	private String customField;

	@SearchParameter(name = "customFieldRequired", provider = StringValueProvider.class)
	private String customFieldRequired;

	@SearchParameter(name = "customFieldRequired2", provider = StringValueProvider.class)
	private String customFieldRequired2;

	public MyExample3403DTO(MyEntity3403 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldRequired = entity.getCustomFieldRequired();
		this.customFieldRequired2 = entity.getCustomFieldRequired2();
	}
}
