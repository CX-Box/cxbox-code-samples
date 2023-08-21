package org.demo.documentation.dictionary.dictionarycsv;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample350DTO extends DataResponseDTO {

	public MyExample350DTO(MyEntity350 entity) {
		this.id = entity.getId().toString();
	}

}