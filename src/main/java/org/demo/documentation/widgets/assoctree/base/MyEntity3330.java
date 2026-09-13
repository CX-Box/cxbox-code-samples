package org.demo.documentation.widgets.assoctree.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.assoctree.base.forfield.MyEntity3330Multi;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3330 extends BaseEntity {

	@JoinTable(name = "MyEntity3330_MyEntity3330Multi",
			joinColumns = @JoinColumn(name = "MyEntity3330_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3330Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3330Multi> customFieldList = new ArrayList<>();
	@Column
	private String customFieldNew;
}