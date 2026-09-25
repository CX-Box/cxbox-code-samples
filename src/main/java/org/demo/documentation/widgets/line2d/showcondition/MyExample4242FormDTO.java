package org.demo.documentation.widgets.line2d.showcondition;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4242FormDTO extends DataResponseDTO {

	public static final String TEXT = "Show condition - if Custom Field > 5 the chart is shown.";

	private Long customField;

	private String customFieldShowCond;

	public MyExample4242FormDTO(MyEntity4242 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldShowCond = entity.getCustomField() > 5 ? "true" : "false";
	}
}
