package org.demo.documentation.additional.forceactiveshowcondition.taxresidency;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample1433DTO extends DataResponseDTO {

	private String country;

	private String tin;

	public MyExample1433DTO(MyEntity1433 entity) {
		this.id = entity.getId().toString();
		this.country = entity.getCountry();
		this.tin = entity.getTin();
	}

}
