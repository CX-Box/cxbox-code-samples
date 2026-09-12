package org.demo.documentation.widgets.assoctree.colortitle;

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
public class MyEntity3332 extends BaseEntity {

	@JoinTable(name = "MyEntity3332_MyEntity3332MultiPick",
			joinColumns = @JoinColumn(name = "MyEntity3332_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3332Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3332Multi> customFieldMultiList = new ArrayList<>();
	@JoinTable(name = "MyEntity3332_MyEntity3332MultiPick0",
			joinColumns = @JoinColumn(name = "MyEntity3332_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3332Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3332Multi> customFieldMultiConstList = new ArrayList<>();
}