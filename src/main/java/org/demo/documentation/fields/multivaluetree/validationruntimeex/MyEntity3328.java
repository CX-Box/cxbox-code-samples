package org.demo.documentation.fields.multivaluetree.validationruntimeex;

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
public class MyEntity3328 extends BaseEntity {

	@JoinTable(name = "MyEntity3328_MyEntity3328Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3328_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3328Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3328Multivalue> customFieldList = new ArrayList<>();

}