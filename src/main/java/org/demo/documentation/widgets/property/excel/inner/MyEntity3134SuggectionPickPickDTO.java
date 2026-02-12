package org.demo.documentation.widgets.property.excel.inner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134SuggectionPick;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3134SuggectionPickPickDTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = StringValueProvider.class)
	private String customField;

	public MyEntity3134SuggectionPickPickDTO(MyEntity3134SuggectionPick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
