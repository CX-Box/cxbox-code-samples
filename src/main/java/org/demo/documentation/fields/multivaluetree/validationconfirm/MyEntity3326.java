package org.demo.documentation.fields.multivaluetree.validationconfirm;

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
public class MyEntity3326 extends BaseEntity {

	@JoinTable(name = "MyEntity3326_MyEntity3326Multivalue",
			joinColumns = @JoinColumn(name = "MyEntity3326_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3326Multivalue_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity3326Multivalue> customFieldList = new ArrayList<>();

}