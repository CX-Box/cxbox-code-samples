package org.demo.documentation.fields.property.snapshotkey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5900PickDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample5900PickDTO(MyEntity5900Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
