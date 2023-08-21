package org.demo.documentation.multivaluero.colorconst;

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
public class MyEntity204 extends BaseEntity {

	@JoinTable(name = "MyEntity204_MyEntity205",
			joinColumns = @JoinColumn(name = "MyEntity204_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity205_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity205> customFieldList = new ArrayList<>();

}