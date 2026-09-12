package org.demo.documentation.fields.multivaluetree.color;

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
public class MyEntity3315 extends BaseEntity {

	@JoinTable(name = "MyEntity3315_MyEntity3315Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3315_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3315Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3315Multivalue> customFieldList = new ArrayList<>();

}