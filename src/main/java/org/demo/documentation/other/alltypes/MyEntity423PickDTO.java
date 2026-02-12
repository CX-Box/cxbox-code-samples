package org.demo.documentation.other.alltypes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity423PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity423PickDTO(MyEntity423 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
