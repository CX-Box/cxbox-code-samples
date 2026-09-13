package org.demo.documentation.fields.multivaluetree.colorconst;

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
public class MyEntity3316 extends BaseEntity {

	@JoinTable(name = "MyEntity3316_MyEntity3316Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3316_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3316Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3316Multivalue> customFieldList = new ArrayList<>();

}