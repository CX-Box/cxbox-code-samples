package org.demo.documentation.widgets.relationGraph.color;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample6157DTO extends DataResponseDTO {

	private String sourceNodeId;

	private String targetNodeId;

	private String targetNodeName;

	private String targetNodeColor;

	private Long edgeValue;

	private String edgeColor;

}
