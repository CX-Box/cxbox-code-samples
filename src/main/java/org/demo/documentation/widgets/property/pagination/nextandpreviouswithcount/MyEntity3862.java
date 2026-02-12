package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forassoc.MyEntity3862Assoc;
import org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forpicklist.MyEntity3862Pick;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3862 extends BaseEntity {
	@Column
	private String customField;
	@JoinColumn(name = "CUSTOM_FIELD_PICKLIST_ID")
	@ManyToOne
	private MyEntity3862Pick customFieldPicklistEntity;
	@JoinTable(name = "MyEntity3862_MyEntity3862AssocPick",
			joinColumns = @JoinColumn(name = "MyEntity3862_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3862Assoc_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3862Assoc> customFieldMultivalueDisplayedKeyList = new ArrayList<>();
}