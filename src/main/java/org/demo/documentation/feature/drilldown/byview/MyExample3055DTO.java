package org.demo.documentation.feature.drilldown.byview;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3055DTO extends DataResponseDTO {

	private String customField;

	public MyExample3055DTO(MyEntity3055 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}