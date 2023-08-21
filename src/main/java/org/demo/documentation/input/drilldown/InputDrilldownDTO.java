package org.demo.documentation.input.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class InputDrilldownDTO extends DataResponseDTO {

	private String customField;

	public InputDrilldownDTO(InputDrilldown entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}