package org.demo.documentation.widgets.filepreview.additionalinfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5011DTO extends DataResponseDTO {

	private String customField;

	private String document;

	private String documentId;

	public MyExample5011DTO(MyEntity5011 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.document = entity.getDocument();
		this.documentId = entity.getDocumentId();
	}

}
