package org.demo.documentation.widgets.assoctree.actions.other.buttonassoc;

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
public class MyEntity3333 extends BaseEntity {


	@JoinTable(name = "MyEntity3333_MyEntity3333Multi",
			joinColumns = @JoinColumn(name = "MyEntity3333_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3333Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3333Multi> customFieldList = new ArrayList<>();
	@Column
	private String customFieldText;
}