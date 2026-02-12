package org.demo.documentation.fields.multivalue.required;

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
public class MyEntity188 extends BaseEntity {

	@JoinTable(name = "MyEntity188_MyEntity189",
			joinColumns = @JoinColumn(name = "MyEntity188_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity189_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity189> customFieldList = new ArrayList<>();

}