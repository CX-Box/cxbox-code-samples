package org.demo.documentation.multivaluero.drilldown;

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
public class MyEntity208 extends BaseEntity {

	@JoinTable(name = "MyEntity208_MyEntity209",
			joinColumns = @JoinColumn(name = "MyEntity208_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity209_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity209> customFieldList = new ArrayList<>();

}