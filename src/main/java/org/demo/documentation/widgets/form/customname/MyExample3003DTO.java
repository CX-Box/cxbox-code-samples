package org.demo.documentation.widgets.form.customname;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3003DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customTitleField", provider = StringValueProvider.class)
	private String customTitleField;

	public MyExample3003DTO(MyEntity3003 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customTitleField = entity.getCustomTitleField();
	}

}