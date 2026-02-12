package org.demo.documentation.fields.multivalue.drilldown;

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
public class MyEntity182 extends BaseEntity {

	@JoinTable(name = "MyEntity182_MyEntity183",
			joinColumns = @JoinColumn(name = "MyEntity182_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity183_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity183> customFieldList = new ArrayList<>();

}