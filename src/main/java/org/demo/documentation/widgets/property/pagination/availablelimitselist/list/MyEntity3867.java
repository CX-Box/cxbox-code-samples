package org.demo.documentation.widgets.property.pagination.availablelimitselist.list;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.property.pagination.availablelimitselist.multivalue.MyEntity3867Multi;
import org.demo.documentation.widgets.property.pagination.availablelimitselist.picklistpopup.MyEntity3867Pick;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3867 extends BaseEntity {
	@Column
	private String customField;
	@JoinTable(name = "MyEntity3867_MyEntity3867MultiPick",
			joinColumns = @JoinColumn(name = "MyEntity3867_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3867Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3867Multi> customFieldMultivalueList = new ArrayList<>();
	@JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
	@ManyToOne
	private MyEntity3867Pick customFieldPickListEntity;
}