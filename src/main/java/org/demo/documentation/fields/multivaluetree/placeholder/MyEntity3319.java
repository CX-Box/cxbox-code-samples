package org.demo.documentation.fields.multivaluetree.placeholder;

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
public class MyEntity3319 extends BaseEntity {

	@JoinTable(name = "MyEntity3319_MyEntity3319Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3319_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3319Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3319Multivalue> customFieldList = new ArrayList<>();

	@JoinTable(name = "MyEntity3319_MyEntity3319Multivalue_RO",
			joinColumns = @JoinColumn(name = "MyEntity3319_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3319Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3319Multivalue> customFieldROList = new ArrayList<>();

}