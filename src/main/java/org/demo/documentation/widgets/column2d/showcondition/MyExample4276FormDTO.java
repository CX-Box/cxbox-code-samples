package org.demo.documentation.widgets.column2d.showcondition;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4276FormDTO extends DataResponseDTO {

	public static final String TEXT = "Show condition - if Custom Field > 5 the chart is shown.";

	private Long customField;

	// --8<-- [start:customFieldShowCond]
	private String customFieldShowCond;
	// --8<-- [end:customFieldShowCond]

	public MyExample4276FormDTO(MyEntity4276 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldShowCond = entity.getCustomField() != null && entity.getCustomField() > 5 ? "true" : "false";
	}

}
