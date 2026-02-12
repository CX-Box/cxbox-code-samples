package org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyEntity3625PickDTO extends DataResponseDTO {
	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;

	public MyEntity3625PickDTO(org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();
	}

}
