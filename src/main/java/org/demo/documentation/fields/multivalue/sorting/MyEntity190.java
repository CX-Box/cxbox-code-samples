package org.demo.documentation.fields.multivalue.sorting;

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
public class MyEntity190 extends BaseEntity {

	@JoinTable(name = "MyEntity190_MyEntity191",
			joinColumns = @JoinColumn(name = "MyEntity190_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity191_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity191> customFieldList = new ArrayList<>();

}