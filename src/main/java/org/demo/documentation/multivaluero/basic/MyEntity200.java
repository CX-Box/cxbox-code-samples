package org.demo.documentation.multivaluero.basic;

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
public class MyEntity200 extends BaseEntity {

	@JoinTable(name = "MyEntity200_MyEntity201",
			joinColumns = @JoinColumn(name = "MyEntity200_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity201_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity201> customFieldList = new ArrayList<>();

}