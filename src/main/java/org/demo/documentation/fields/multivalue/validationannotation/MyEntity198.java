package org.demo.documentation.fields.multivalue.validationannotation;

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
public class MyEntity198 extends BaseEntity {

	@JoinTable(name = "MyEntity198_MyEntity199",
			joinColumns = @JoinColumn(name = "MyEntity198_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity199_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity199> customFieldList = new ArrayList<>();

}