package org.demo.documentation.widgets.property.pagination.hidelimitoptions.list;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue.MyEntity3865Multi;
import org.demo.documentation.widgets.property.pagination.hidelimitoptions.picklistpopup.MyEntity3865Pick;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3865 extends BaseEntity {
	@Column
	private String customField;
	@JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
	@ManyToOne
	private MyEntity3865Pick customFieldPickListEntity;
	@JoinTable(name = "MyEntity3865_MyEntity3865MultiPick",
			joinColumns = @JoinColumn(name = "MyEntity3865_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3865Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3865Multi> customFieldMultivalueList = new ArrayList<>();
}