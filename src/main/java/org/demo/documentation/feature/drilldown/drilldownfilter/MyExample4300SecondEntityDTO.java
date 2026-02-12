package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4300SecondEntityDTO extends DataResponseDTO {

	public MyExample4300SecondEntityDTO(MyEntity4300SecondEntity entity) {
		this.id = entity.getId().toString();
	}

}
