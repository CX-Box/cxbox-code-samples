package org.demo.documentation.widgets.assoctree.colortitle.allfields;

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
public class MyEntity3329 extends BaseEntity {
	@Column
	private String customField;
	@JoinTable(name = "MyEntity3329_MyEntity3329Multi",
			joinColumns = @JoinColumn(name = "MyEntity3329_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3329Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3329Multi> customFieldMultiList = new ArrayList<>();
}