package org.demo.documentation.multivalue.primary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity2000 extends BaseEntity {


	@JoinTable(name = "MyEntity2000_MyEntity2001",
			joinColumns = @JoinColumn(name = "MyEntity2000_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity2001_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity2001> customFieldList = new ArrayList<>();

	private Long primaryId;
}