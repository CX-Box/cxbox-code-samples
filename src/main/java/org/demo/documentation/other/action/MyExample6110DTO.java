package org.demo.documentation.other.action;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample6110DTO extends DataResponseDTO {

	private String text = "Text";

	public MyExample6110DTO(MyExample6110Entity entity) {
		this.id = Optional.ofNullable(entity.getId()).map(String::valueOf).orElse(null);
	}
}
