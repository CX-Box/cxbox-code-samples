package org.demo.documentation.widgets.relationGraph;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.relationGraph.enums.TargetNodeTypeEnum;


@Entity
@Table(name = "MYEXAMPLE6150")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class Myexample6150 extends BaseEntity {


	@Column
	private String sourceNodeId;

	@Column
	private String targetNodeId;

	@Column
	private String targetNodeBgColorKey;

	@Enumerated(value = EnumType.STRING)
	@Column
	private TargetNodeTypeEnum targetNodeType;

	@Column
	private String targetNodeName;

	@Column
	private String edgeDescription;

	@Column
	private String edgeValue;

	@Column
	private String edgeValueBgColorKey;

	@Column
	private String targetNodeDescription;
}