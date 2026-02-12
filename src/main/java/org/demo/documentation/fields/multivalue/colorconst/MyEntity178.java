package org.demo.documentation.fields.multivalue.colorconst;

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
public class MyEntity178 extends BaseEntity {

	@JoinTable(name = "MyEntity178_MyEntity179",
			joinColumns = @JoinColumn(name = "MyEntity178_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity179_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity179> customFieldList = new ArrayList<>();

}