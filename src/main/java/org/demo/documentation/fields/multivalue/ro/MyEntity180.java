package org.demo.documentation.fields.multivalue.ro;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;


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