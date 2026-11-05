package org.demo.documentation.widgets.relationGraph.title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample6152DTO extends DataResponseDTO {

	private String sourceNodeId;

	private String targetNodeId;

	private String targetNodeName;

	private Long edgeValue;

}
