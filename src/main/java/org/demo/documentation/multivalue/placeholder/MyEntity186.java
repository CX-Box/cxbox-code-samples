package org.demo.documentation.multivalue.placeholder;

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
public class MyEntity186 extends BaseEntity {

	@JoinTable(name = "MyEntity186_MyEntity187",
			joinColumns = @JoinColumn(name = "MyEntity186_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity187_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity187> customFieldList = new ArrayList<>();

}