package org.demo.documentation.fields.multivaluetree.required;

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
public class MyEntity3321 extends BaseEntity {

	@JoinTable(name = "MyEntity3321_MyEntity3321Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3321_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3321Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3321Multivalue> customFieldList = new ArrayList<>();

}