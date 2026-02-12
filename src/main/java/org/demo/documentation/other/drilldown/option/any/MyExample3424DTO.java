package org.demo.documentation.other.drilldown.option.any;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3424DTO extends DataResponseDTO {
	private String customField;

	public MyExample3424DTO(MyEntity3424OutServiceDTO entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}