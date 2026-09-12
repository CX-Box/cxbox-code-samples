package org.demo.documentation.fields.multivaluetree.ro;

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
public class MyEntity3322 extends BaseEntity {

	@JoinTable(name = "MyEntity3322_MyEntity3322Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3322_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3322Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3322Multivalue> customFieldList = new ArrayList<>();

}