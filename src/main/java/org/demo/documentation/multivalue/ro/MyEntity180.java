package org.demo.documentation.multivalue.ro;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity180 extends BaseEntity {

	@JoinTable(name = "MyEntity180_MyEntity181",
			joinColumns = @JoinColumn(name = "MyEntity180_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity181_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity181> customFieldList = new ArrayList<>();

}