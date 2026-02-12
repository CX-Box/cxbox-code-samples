package org.demo.documentation.widgets.property.defaultlimitpage.forassoc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity359AssocPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity359AssocPickDTO(MyEntity359Assoc entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
