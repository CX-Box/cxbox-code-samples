package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.forproject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity4903FileNamePickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity4903FileNamePickPickDTO(MyEntity4903FileNamePick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
