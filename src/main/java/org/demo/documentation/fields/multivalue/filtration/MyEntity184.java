package org.demo.documentation.fields.multivalue.filtration;

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
public class MyEntity184 extends BaseEntity {

	@JoinTable(name = "MyEntity184_MyEntity185",
			joinColumns = @JoinColumn(name = "MyEntity184_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity185_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity185> customFieldList = new ArrayList<>();

}