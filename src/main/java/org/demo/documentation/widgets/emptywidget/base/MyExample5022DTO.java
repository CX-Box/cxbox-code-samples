package org.demo.documentation.widgets.emptywidget.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5022DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample5022DTO(MyEntity5022 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}
