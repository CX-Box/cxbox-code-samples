package org.demo.documentation.navigation.tab.other.example1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3123DTO extends DataResponseDTO {

	private String customField;

	public MyExample3123DTO(MyEntity3123 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}