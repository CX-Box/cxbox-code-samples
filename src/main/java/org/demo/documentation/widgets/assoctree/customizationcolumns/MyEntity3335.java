package org.demo.documentation.widgets.assoctree.customizationcolumns;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3335 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldTest;
	@Column
	private Long customFieldNumber;
	@JoinTable(name = "MyEntity3335_MyEntity3335AssocPick",
			joinColumns = @JoinColumn(name = "MyEntity3335_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3335Assoc_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3335Assoc> customFieldMultivalueList = new ArrayList<>();
}