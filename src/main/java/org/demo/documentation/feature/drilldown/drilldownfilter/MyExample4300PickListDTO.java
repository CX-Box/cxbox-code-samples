package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4300PickListDTO extends DataResponseDTO {

	@SearchParameter(name = "value")
	private String value;

	public MyExample4300PickListDTO(MyEntity4300PickList entity) {
		this.id = entity.getId().toString();
		this.value = entity.getValue();
	}

}
