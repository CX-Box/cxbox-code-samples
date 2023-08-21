package org.demo.documentation.multivaluero.ro;

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
public class MyEntity206 extends BaseEntity {

	@JoinTable(name = "MyEntity206_MyEntity207",
			joinColumns = @JoinColumn(name = "MyEntity206_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity207_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity207> customFieldList = new ArrayList<>();

}