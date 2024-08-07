package org.demo.documentation.fields.multivalue.validationannotation;

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
public class MyEntity198 extends BaseEntity {

	@JoinTable(name = "MyEntity198_MyEntity199",
			joinColumns = @JoinColumn(name = "MyEntity198_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity199_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity199> customFieldList = new ArrayList<>();

}