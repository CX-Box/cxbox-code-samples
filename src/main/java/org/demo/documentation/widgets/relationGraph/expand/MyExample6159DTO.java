package org.demo.documentation.widgets.relationGraph.expand;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.widgets.relationGraph.enums.TargetNodeTypeEnum;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample6159DTO extends DataResponseDTO {

	private String sourceNodeId;

	private String targetNodeId;

	private String targetNodeName;

	private TargetNodeTypeEnum targetNodeType;

	private Boolean targetNodeExpanded;

	private Long edgeValue;

}
