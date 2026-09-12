package org.demo.documentation.fields.multivaluetree.sorting;

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
public class MyEntity3323 extends BaseEntity {

	@JoinTable(name = "MyEntity3323_MyEntity3323Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3323_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3323Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3323Multivalue> customFieldList = new ArrayList<>();

}