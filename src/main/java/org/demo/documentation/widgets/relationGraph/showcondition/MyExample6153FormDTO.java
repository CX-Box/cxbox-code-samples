package org.demo.documentation.widgets.relationGraph.showcondition;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample6153FormDTO extends DataResponseDTO {

	public static final String TEXT = "Show condition - if Custom Field > 5 the graph is shown.";

	private Long customField;

	private String customFieldShowCond;

	public MyExample6153FormDTO(MyEntity6153 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldShowCond = entity.getCustomField() > 5 ? "true" : "false";
	}
}
