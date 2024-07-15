package org.demo.documentation.fields.multivaluehover.required;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample236DTO extends DataResponseDTO {

	public MyExample236DTO(MyEntity236 entity) {
		this.id = entity.getId().toString();
	}

}