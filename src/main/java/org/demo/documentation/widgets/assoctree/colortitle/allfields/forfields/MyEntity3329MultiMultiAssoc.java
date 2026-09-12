package org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.MyEntity3329Multi;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3329MultiMultiAssoc extends BaseEntity {
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

	@Column
	private Long parentId;

	@OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
	private List<MyEntity3329MultiMultiAssoc> children = new ArrayList<>();

}
