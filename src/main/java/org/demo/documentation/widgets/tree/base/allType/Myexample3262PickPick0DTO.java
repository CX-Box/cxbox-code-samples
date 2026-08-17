package org.demo.documentation.widgets.tree.base.allType;

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
public class Myexample3262PickPick0DTO extends DataResponseDTO {

	@SearchParameter(name = "customField2", provider = StringValueProvider.class)
	private String customField2;

	public Myexample3262PickPick0DTO(Myexample3262Pick entity) {
		this.id = entity.getId().toString();
		this.customField2 = entity.getCustomField2();
	}

}
