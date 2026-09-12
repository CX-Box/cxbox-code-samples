package org.demo.documentation.widgets.picktree.actions.other.createwithparent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3350Pick extends BaseEntity {
	@Column
	private String customField;

	@Column
	private Long parentId;

	@OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
	private List<MyEntity3350Pick> children = new ArrayList<>();

}
