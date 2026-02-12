package org.demo.documentation.widgets.assoc.actions;

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
public class MyEntity3054 extends BaseEntity {

	@JoinTable(name = "MyEntity3054_MyEntity3054Multi",
			joinColumns = @JoinColumn(name = "MyEntity3054_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3054Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3054Multi> customFieldList = new ArrayList<>();
}