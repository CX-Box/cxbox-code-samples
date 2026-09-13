package org.demo.documentation.fields.multivaluetree.validationdynamic;

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
public class MyEntity3327 extends BaseEntity {

	@JoinTable(name = "MyEntity3327_MyEntity3327Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3327_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3327Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3327Multivalue> customFieldList = new ArrayList<>();

}