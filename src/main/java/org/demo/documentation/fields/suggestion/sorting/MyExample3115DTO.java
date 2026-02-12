package org.demo.documentation.fields.suggestion.sorting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3115DTO extends DataResponseDTO {

	public MyExample3115DTO(MyEntity3115OutServiceDTO entity) {
		this.id = entity.getId().toString();
	}
}