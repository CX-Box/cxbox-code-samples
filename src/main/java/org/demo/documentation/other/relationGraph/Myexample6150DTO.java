package org.demo.documentation.other.relationGraph;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.relationGraph.enums.TargetNodeTypeEnum;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class Myexample6150DTO extends DataResponseDTO {


	@SearchParameter(name = "sourceNodeId", provider = StringValueProvider.class)
	private String sourceNodeId;

	@SearchParameter(name = "targetNodeId", provider = StringValueProvider.class)
	private String targetNodeId;

	@SearchParameter(name = "targetNodeBgColorKey", provider = StringValueProvider.class)
	private String targetNodeBgColorKey;

	@SearchParameter(name = "targetNodeType", provider = EnumValueProvider.class)
	private TargetNodeTypeEnum targetNodeType;

	@SearchParameter(name = "targetNodeName", provider = StringValueProvider.class)
	private String targetNodeName;

	@SearchParameter(name = "edgeDescription", provider = StringValueProvider.class)
	private String edgeDescription;

	private String edgeValue;

	private String edgeValueBgColorKey;

	@SearchParameter(name = "targetNodeDescription", provider = StringValueProvider.class)
	private String targetNodeDescription;

	public Myexample6150DTO(Myexample6150 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.sourceNodeId = entity.getSourceNodeId();
		this.targetNodeId = entity.getTargetNodeId();
		this.targetNodeBgColorKey = entity.getTargetNodeBgColorKey();
		this.targetNodeType = entity.getTargetNodeType();
		this.targetNodeName = entity.getTargetNodeName();
		this.edgeDescription = entity.getEdgeDescription();
		this.edgeValue = entity.getEdgeValue();
		this.edgeValueBgColorKey = entity.getEdgeValueBgColorKey();
		this.targetNodeDescription = entity.getTargetNodeDescription();
	}

}
