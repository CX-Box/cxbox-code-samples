package org.demo.documentation.widgets.filepreview.header;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5008DTO extends DataResponseDTO {

	private String document;

	private String documentId;

	private String customFieldTitle;

	private String customFieldHint;

	public MyExample5008DTO(MyEntity5008 entity) {
		this.id = entity.getId().toString();
		this.document = entity.getDocument();
		this.documentId = entity.getDocumentId();
		this.customFieldTitle = entity.getCustomFieldTitle();
		this.customFieldHint = entity.getCustomFieldHint();
	}

}
