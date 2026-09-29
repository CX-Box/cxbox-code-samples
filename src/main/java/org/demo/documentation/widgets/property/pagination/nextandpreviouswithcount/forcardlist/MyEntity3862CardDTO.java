package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forcardlist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3862CardDTO extends DataResponseDTO {

	private String document;

	private String documentId;

	private String customField;

	private String customFieldDescription;

	public MyEntity3862CardDTO(MyEntity3862Card entity) {
		this.id = entity.getId().toString();
		this.document = entity.getDocument();
		this.documentId = entity.getDocumentId();
		this.customField = entity.getCustomField();
		this.customFieldDescription = entity.getCustomFieldDescription();
	}

}
