package org.demo.documentation.hidden.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class HiddenBasicDTO extends DataResponseDTO {

	private String customField;

	public HiddenBasicDTO(HiddenBasic entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}