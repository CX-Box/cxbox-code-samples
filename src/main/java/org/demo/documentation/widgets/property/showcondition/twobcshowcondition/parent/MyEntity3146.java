package org.demo.documentation.widgets.property.showcondition.twobcshowcondition.parent;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3146 extends BaseEntity {
	@Column
	private Long customField = 0L;

	/** The tree tab: the parent record, empty for a root record. */
	@Column
	private Long parentId;

	@OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
	private List<MyEntity3146> children = new ArrayList<>();
}
