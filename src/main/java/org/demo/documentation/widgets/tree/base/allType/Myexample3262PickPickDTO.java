package org.demo.documentation.widgets.tree.base.allType;

import java.lang.String;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Pick;

@Getter
@Setter
@NoArgsConstructor
public class Myexample3262PickPickDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public Myexample3262PickPickDTO(Myexample3262Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
