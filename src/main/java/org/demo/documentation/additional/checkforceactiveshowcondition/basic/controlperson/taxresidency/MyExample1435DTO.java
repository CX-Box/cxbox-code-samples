package org.demo.documentation.additional.checkforceactiveshowcondition.basic.controlperson.taxresidency;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample1435DTO extends DataResponseDTO {

	private String country;

	private String tin;

	public MyExample1435DTO(MyEntity1435 entity) {
		this.id = entity.getId().toString();
		this.country = entity.getCountry();
		this.tin = entity.getTin();
	}

}
