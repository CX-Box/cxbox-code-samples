package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity4902SuggectionPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity4902SuggectionPickDTO(MyEntity4902Suggection entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
