package org.demo.documentation.widgets.cardcarousellist.colortitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5062DTO extends DataResponseDTO {

	private String document;

	private String documentId;

	@SearchParameter(name = "customField")
	private String customField;

	private String customFieldDescription;

	// --8<-- [start:colorDTO]
	private String customFieldColor;
	// --8<-- [end:colorDTO]

	public MyExample5062DTO(MyEntity5062 entity) {
		this.id = entity.getId().toString();
		this.document = entity.getDocument();
		this.documentId = entity.getDocumentId();
		this.customField = entity.getCustomField();
		this.customFieldDescription = entity.getCustomFieldDescription();
		this.customFieldColor = entity.getCustomFieldColor();
	}

}
