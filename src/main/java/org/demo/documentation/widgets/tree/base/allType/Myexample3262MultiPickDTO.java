package org.demo.documentation.widgets.tree.base.allType;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class Myexample3262MultiPickDTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = StringValueProvider.class)
	private String customField;

	public Myexample3262MultiPickDTO(Myexample3262Multi entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
