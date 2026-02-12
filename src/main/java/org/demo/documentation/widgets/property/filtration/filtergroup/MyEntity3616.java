package org.demo.documentation.widgets.property.filtration.filtergroup;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.property.filtration.filtergroup.forassoc.MyEntity3623;
import org.demo.documentation.widgets.property.filtration.filtergroup.forpicklist.MyEntity3630;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3616 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldNew;
	@JoinTable(name = "MyEntity3616_MyEntity3623Pick",
			joinColumns = @JoinColumn(name = "MyEntity3616_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3623_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3623> customFieldMultivalueList = new ArrayList<>();
	@JoinColumn(name = "CUSTOM_FIELD_PICKLIST_ID")
	@ManyToOne
	private MyEntity3630 customFieldPicklistEntity;
}