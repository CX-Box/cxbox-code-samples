package org.demo.documentation.fields.multivalue.validationruntimeex;

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
public class MyEntity196 extends BaseEntity {

	@JoinTable(name = "MyEntity196_MyEntity197",
			joinColumns = @JoinColumn(name = "MyEntity196_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity197_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity197> customFieldList = new ArrayList<>();

}