package org.demo.documentation.fields.multivalue.validationconfirm;

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
public class MyEntity194 extends BaseEntity {

	@JoinTable(name = "MyEntity194_MyEntity195",
			joinColumns = @JoinColumn(name = "MyEntity194_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity195_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity195> customFieldList = new ArrayList<>();

}