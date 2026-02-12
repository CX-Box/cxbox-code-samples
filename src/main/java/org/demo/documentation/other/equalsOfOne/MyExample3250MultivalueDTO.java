package org.demo.documentation.other.equalsOfOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3250MultivalueDTO extends DataResponseDTO {

	private String name;

	public MyExample3250MultivalueDTO(MyExample3250Multivalue entity) {
		this.id = entity.getId().toString();
		this.name = entity.getName();
	}

}