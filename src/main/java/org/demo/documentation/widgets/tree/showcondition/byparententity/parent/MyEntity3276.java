package org.demo.documentation.widgets.tree.showcondition.byparententity.parent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.showcondition.byparententity.BaseTreeEntity;

import java.util.ArrayList;
import java.util.List;

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
	private Long parentId;

	@Column
	private Double customFieldMoney;

	@Column
	private Long parentTreeId;

	@OneToMany(
			mappedBy = "parentTreeId",
			fetch = FetchType.LAZY
	)
	private List<MyEntity3276> children = new ArrayList<>();
}