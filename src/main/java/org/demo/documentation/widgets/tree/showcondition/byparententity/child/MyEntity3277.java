package org.demo.documentation.widgets.tree.showcondition.byparententity.child;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.showcondition.byparententity.BaseTreeEntity;
import org.demo.documentation.widgets.tree.showcondition.byparententity.parent.MyEntity3276;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3277 extends BaseEntity implements BaseTreeEntity {
	@Column
	private String customField;
	@Column
	private Long customFieldNumber = 0L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private MyEntity3276 customFieldEntity;

	@Column
	private Double customFieldMoney;

	@Column
	private Long parentTreeId;

	@OneToMany(mappedBy = "parentTreeId", fetch = FetchType.LAZY)
	private List<MyEntity3277> children = new ArrayList<>();

}
