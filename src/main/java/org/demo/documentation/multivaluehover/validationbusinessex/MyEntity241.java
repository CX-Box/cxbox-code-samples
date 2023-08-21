package org.demo.documentation.multivaluehover.validationbusinessex;

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
public class MyEntity241 extends BaseEntity {

	@JoinTable(name = "MyEntity241_MyEntity242",
			joinColumns = @JoinColumn(name = "MyEntity241_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity242_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity242> customFieldList = new ArrayList<>();

}