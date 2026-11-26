package org.demo.documentation.widgets.list.fieldtitle;

import java.time.Year;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample6165DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	// --8<-- [start:customFieldTitle]
	private String customFieldTitle;
	// --8<-- [end:customFieldTitle]

	public MyExample6165DTO(MyEntity6165 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		// --8<-- [start:customFieldTitleValue]
		this.customFieldTitle = "Custom Field, " + Year.now();
		// --8<-- [end:customFieldTitleValue]
	}
}
