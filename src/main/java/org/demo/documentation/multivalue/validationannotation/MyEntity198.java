package org.demo.documentation.multivalue.validationannotation;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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