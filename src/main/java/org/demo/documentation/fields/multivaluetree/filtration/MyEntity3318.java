package org.demo.documentation.fields.multivaluetree.filtration;

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
public class MyEntity3318 extends BaseEntity {

	@JoinTable(name = "MyEntity3318_MyEntity3318Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3318_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3318Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3318Multivalue> customFieldList = new ArrayList<>();

}