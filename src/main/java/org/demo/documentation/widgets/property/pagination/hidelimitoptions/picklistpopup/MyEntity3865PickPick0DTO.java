package org.demo.documentation.widgets.property.pagination.hidelimitoptions.picklistpopup;

import java.lang.String;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3865PickPick0DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = StringValueProvider.class)
	private String customField;

	public MyEntity3865PickPick0DTO(MyEntity3865Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
