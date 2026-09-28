package org.demo.documentation.widgets.cardcarousellist.status;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.widgets.cardcarousellist.status.enums.StatusEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5065DTO extends DataResponseDTO {

	private String document;

	private String documentId;

	@SearchParameter(name = "customField")
	private String customField;

	private String customFieldDescription;

	// --8<-- [start:statusDTO]
	@SearchParameter(name = "status", provider = EnumValueProvider.class)
	private StatusEnum status;

	private String statusColor;
	// --8<-- [end:statusDTO]

	public MyExample5065DTO(MyEntity5065 entity) {
		this.id = entity.getId().toString();
		this.document = entity.getDocument();
		this.documentId = entity.getDocumentId();
		this.customField = entity.getCustomField();
		this.customFieldDescription = entity.getCustomFieldDescription();
		this.status = entity.getStatus();
		this.statusColor = entity.getStatus() == null ? null : entity.getStatus().getColor();
	}

}
