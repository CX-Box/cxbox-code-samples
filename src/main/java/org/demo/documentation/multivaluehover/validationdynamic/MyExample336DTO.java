package org.demo.documentation.multivaluehover.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample336DTO extends DataResponseDTO {

	public MyExample336DTO(MyEntity336 entity) {
		this.id = entity.getId().toString();
	}

}