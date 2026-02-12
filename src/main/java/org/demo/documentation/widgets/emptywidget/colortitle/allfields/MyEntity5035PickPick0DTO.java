package org.demo.documentation.widgets.emptywidget.colortitle.allfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity5035PickPick0DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = StringValueProvider.class)
	private String customField;

	public MyEntity5035PickPick0DTO(MyEntity5035Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
