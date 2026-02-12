package org.demo.documentation.widgets.assoc.customizationcolumns;

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
public class MyEntity3078 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldTest;
	@Column
	private Long customFieldNumber;
	@JoinTable(name = "MyEntity3078_MyEntity3078AssocPick",
			joinColumns = @JoinColumn(name = "MyEntity3078_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3078Assoc_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3078Assoc> customFieldMultivalueList = new ArrayList<>();
}