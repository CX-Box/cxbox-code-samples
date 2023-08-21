package org.demo.documentation.multivaluero.placeholder;

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
public class MyEntity212 extends BaseEntity {

	@JoinTable(name = "MyEntity212_MyEntity213",
			joinColumns = @JoinColumn(name = "MyEntity212_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity213_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity213> customFieldList = new ArrayList<>();

}