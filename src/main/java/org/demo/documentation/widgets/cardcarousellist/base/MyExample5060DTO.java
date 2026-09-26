package org.demo.documentation.widgets.cardcarousellist.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5060DTO extends DataResponseDTO {

	private String document;

	private String documentId;

	@SearchParameter(name = "customField")
	private String customField;

	private String customFieldDescription;

	public MyExample5060DTO(MyEntity5060 entity) {
		this.id = entity.getId().toString();
		this.document = entity.getDocument();
		this.documentId = entity.getDocumentId();
		this.customField = entity.getCustomField();
		this.customFieldDescription = entity.getCustomFieldDescription();
	}

}
