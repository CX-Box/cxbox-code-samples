package org.demo.documentation.fields.multivaluetree.validationannotation;

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
public class MyEntity3324 extends BaseEntity {

	@JoinTable(name = "MyEntity3324_MyEntity3324Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3324_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3324Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3324Multivalue> customFieldList = new ArrayList<>();

}