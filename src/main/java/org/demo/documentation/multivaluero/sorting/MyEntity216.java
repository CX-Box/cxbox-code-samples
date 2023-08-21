package org.demo.documentation.multivaluero.sorting;

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
public class MyEntity216 extends BaseEntity {

	@JoinTable(name = "MyEntity216_MyEntity217",
			joinColumns = @JoinColumn(name = "MyEntity216_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity217_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity217> customFieldList = new ArrayList<>();

}