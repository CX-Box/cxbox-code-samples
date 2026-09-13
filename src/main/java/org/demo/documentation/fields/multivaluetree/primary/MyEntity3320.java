package org.demo.documentation.fields.multivaluetree.primary;

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
public class MyEntity3320 extends BaseEntity {


	@JoinTable(name = "MyEntity3320_MyEntity3320Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3320_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3320Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3320Multivalue> customFieldList = new ArrayList<>();

	private Long primaryId;
}