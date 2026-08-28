package org.demo.documentation.widgets.tree.showcondition.byparententity.parent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.showcondition.byparententity.BaseTreeEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3276 extends BaseEntity implements BaseTreeEntity {

	@Column
	private String customField;

	@Column
	private Long customFieldNumber = 0L;

	@Column
	private Boolean customFieldShowCondition;

	@Column
	private String isLeaf;

	@Column
	private String parentId;

	@Column
	private Double customFieldMoney;

	@Column
	private String parentTreeId;
}