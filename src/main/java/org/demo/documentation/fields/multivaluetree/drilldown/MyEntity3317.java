package org.demo.documentation.fields.multivaluetree.drilldown;

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
public class MyEntity3317 extends BaseEntity {

	@JoinTable(name = "MyEntity3317_MyEntity3317Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3317_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3317Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3317Multivalue> customFieldList = new ArrayList<>();

}