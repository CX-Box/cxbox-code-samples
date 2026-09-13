package org.demo.documentation.widgets.assoctree.actions.other.createwithparent;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.assoctree.actions.other.createwithparent.assoc.MyEntity3339;
import org.demo.documentation.widgets.assoctree.actions.other.createwithparent.assocreq.MyEntity3340;
import org.demo.documentation.widgets.assoctree.actions.other.createwithparent.parent.MyEntity3338;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3337 extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private MyEntity3338 customFieldEntity;

	@JoinTable(name = "MyEntity3337_MyEntity3339",
			joinColumns = @JoinColumn(name = "MyEntity3337_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3339_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3339> customFieldList = new ArrayList<>();
	@Column
	private String customFieldText;
	@Column
	private String customFieldTextReq;
	@JoinTable(name = "MyEntity3337_MyEntity3340",
			joinColumns = @JoinColumn(name = "MyEntity3337_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3340_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3340> customFieldReqList = new ArrayList<>();
}