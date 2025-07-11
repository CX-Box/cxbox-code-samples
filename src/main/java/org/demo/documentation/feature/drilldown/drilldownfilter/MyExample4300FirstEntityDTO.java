package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4300FirstEntityDTO extends DataResponseDTO {

	public MyExample4300FirstEntityDTO(MyEntity4300FirstEntity entity) {
		this.id = entity.getId().toString();
	}

}
