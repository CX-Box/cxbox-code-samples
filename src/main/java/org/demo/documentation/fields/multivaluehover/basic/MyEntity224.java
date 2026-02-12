package org.demo.documentation.fields.multivaluehover.basic;

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
public class MyEntity224 extends BaseEntity {

	@JoinTable(name = "MyEntity224_MyEntity259",
			joinColumns = @JoinColumn(name = "MyEntity224_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity259_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity259> customFieldList = new ArrayList<>();

}