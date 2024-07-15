package org.demo.documentation.fields.multivaluehover.validationconfirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample243DTO extends DataResponseDTO {

	public MyExample243DTO(MyEntity243 entity) {
		this.id = entity.getId().toString();
	}

}