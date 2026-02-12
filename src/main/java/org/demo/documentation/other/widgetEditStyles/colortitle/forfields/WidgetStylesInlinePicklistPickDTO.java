package org.demo.documentation.other.widgetEditStyles.colortitle.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class WidgetStylesInlinePicklistPickDTO extends DataResponseDTO {

	private String customField;

	public WidgetStylesInlinePicklistPickDTO(WidgetStylesInlinePicklist entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
