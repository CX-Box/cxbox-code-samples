package org.demo.documentation.additional.checkforceactiveshowcondition.basic.controlperson;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample1434DTO extends DataResponseDTO {

	private String fullName;

	private String inn;

	public MyExample1434DTO(MyEntity1434 entity) {
		this.id = entity.getId().toString();
		this.fullName = entity.getFullName();
		this.inn = entity.getInn();
	}

}
