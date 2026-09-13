package org.demo.documentation.fields.multivaluetree.basic;

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
public class MyEntity3314 extends BaseEntity {

	@JoinTable(name = "MyEntity3314_MyEntity3314Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3314_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3314Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3314Multivalue> customFieldList = new ArrayList<>();

	@Column
	private String customFieldAdditional;

}