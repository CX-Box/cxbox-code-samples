package org.demo.documentation.other.action;

import org.cxbox.api.data.dto.DataResponseDTO;

import java.util.Optional;

public class MyExample6110DTO extends DataResponseDTO {

	public MyExample6110DTO(MyExample6110Entity entity) {
		this.id = Optional.ofNullable(entity.getId()).map(String::valueOf).orElse(null);
	}
}
