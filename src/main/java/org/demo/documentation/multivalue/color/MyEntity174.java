package org.demo.documentation.multivalue.color;

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
public class MyEntity174 extends BaseEntity {

	@JoinTable(name = "MyEntity174_MyEntity175",
			joinColumns = @JoinColumn(name = "MyEntity174_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity175_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity175> customFieldList = new ArrayList<>();

}