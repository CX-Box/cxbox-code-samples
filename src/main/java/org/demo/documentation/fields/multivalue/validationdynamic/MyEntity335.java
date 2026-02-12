package org.demo.documentation.fields.multivalue.validationdynamic;

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
public class MyEntity335 extends BaseEntity {

	@JoinTable(name = "MyEntity335_MyEntity337",
			joinColumns = @JoinColumn(name = "MyEntity335_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity337_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity337> customFieldList = new ArrayList<>();

}