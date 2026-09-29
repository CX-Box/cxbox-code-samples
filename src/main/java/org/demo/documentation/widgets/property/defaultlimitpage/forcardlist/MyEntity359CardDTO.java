package org.demo.documentation.widgets.property.defaultlimitpage.forcardlist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity359CardDTO extends DataResponseDTO {

	private String document;

	private String documentId;

	private String customField;

	private String customFieldDescription;

	public MyEntity359CardDTO(MyEntity359Card entity) {
		this.id = entity.getId().toString();
		this.document = entity.getDocument();
		this.documentId = entity.getDocumentId();
		this.customField = entity.getCustomField();
		this.customFieldDescription = entity.getCustomFieldDescription();
	}

}
