package org.demo.documentation.fields.multivalue.validationbusinessex;

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
public class MyEntity192 extends BaseEntity {

	@JoinTable(name = "MyEntity192_MyEntity193",
			joinColumns = @JoinColumn(name = "MyEntity192_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity193_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity193> customFieldList = new ArrayList<>();

}