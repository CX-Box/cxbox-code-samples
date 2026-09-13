package org.demo.documentation.widgets.assoctree.title;

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
public class MyEntity3336 extends BaseEntity {
	@Column
	private String customField;
	@JoinTable(name = "MyEntity3336_MyEntity3336MultiPick",
			joinColumns = @JoinColumn(name = "MyEntity3336_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3336Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3336Multi> customFieldMultivalueList = new ArrayList<>();
}