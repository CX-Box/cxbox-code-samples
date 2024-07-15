package org.demo.documentation.fields.multivalue.validationbusinessex;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


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