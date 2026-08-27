package org.demo.documentation.widgets.tree.customizationcolumns.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262MultiHover;
@Getter
@Setter
@NoArgsConstructor
public class MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MultivalueDTO(Myexample3262MultiHover entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
