package org.demo.documentation.fields.multivaluetree.validationbusinessex;

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
public class MyEntity3325 extends BaseEntity {

	@JoinTable(name = "MyEntity3325_MyEntity3325Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3325_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3325Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3325Multivalue> customFieldList = new ArrayList<>();

}