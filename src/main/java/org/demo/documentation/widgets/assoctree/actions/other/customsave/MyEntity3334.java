package org.demo.documentation.widgets.assoctree.actions.other.customsave;

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
public class MyEntity3334 extends BaseEntity {

	@JoinTable(name = "MyEntity3334_MyEntity3334Multi",
			joinColumns = @JoinColumn(name = "MyEntity3334_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3334Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3334Multi> customFieldList = new ArrayList<>();
	@Column
	private String customFieldRequired;
}