package org.demo.documentation.fields.multivaluehover.validationruntimeex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample245DTO extends DataResponseDTO {

	public MyExample245DTO(MyEntity245 entity) {
		this.id = entity.getId().toString();
	}

}