package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.cxbox.api.data.dto.DataResponseDTO;

/**
 * DTO for {@link MyEntity4300Multivalue}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MyExample4300MultivalueDTO extends DataResponseDTO {

	private String value;

	public MyExample4300MultivalueDTO(MyEntity4300Multivalue myEntity4300Multivalue) {
		this.id = String.valueOf(myEntity4300Multivalue.getId());
		this.value = myEntity4300Multivalue.getValue();
	}

}
