package org.demo.documentation.widgets.assoctree.actions;

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
public class MyEntity3331 extends BaseEntity {

	@JoinTable(name = "MyEntity3331_MyEntity3331Multi",
			joinColumns = @JoinColumn(name = "MyEntity3331_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3331Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3331Multi> customFieldList = new ArrayList<>();
}