package org.demo.documentation.multivalue.colorconst;

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
public class MyEntity178 extends BaseEntity {

	@JoinTable(name = "MyEntity178_MyEntity179",
			joinColumns = @JoinColumn(name = "MyEntity178_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity179_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity179> customFieldList = new ArrayList<>();

}