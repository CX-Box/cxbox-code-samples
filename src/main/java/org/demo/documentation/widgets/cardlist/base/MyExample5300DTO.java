package org.demo.documentation.widgets.cardlist.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5300DTO extends DataResponseDTO {

	private String document;

	private String documentId;

	private String customField;

	private String customFieldDescription;

	public MyExample5300DTO(MyEntity5300 entity) {
		this.id = entity.getId().toString();
		this.document = entity.getDocument();
		this.documentId = entity.getDocumentId();
		this.customField = entity.getCustomField();
		this.customFieldDescription = entity.getCustomFieldDescription();
	}

}
