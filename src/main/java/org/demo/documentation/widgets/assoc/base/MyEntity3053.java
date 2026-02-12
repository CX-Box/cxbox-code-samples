package org.demo.documentation.widgets.assoc.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.assoc.base.forfield.MyEntity3053Multi;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3053 extends BaseEntity {

	@JoinTable(name = "MyEntity3053_MyEntity3053Multi",
			joinColumns = @JoinColumn(name = "MyEntity3053_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3053Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3053Multi> customFieldList = new ArrayList<>();
	@Column
	private String customFieldNew;
}