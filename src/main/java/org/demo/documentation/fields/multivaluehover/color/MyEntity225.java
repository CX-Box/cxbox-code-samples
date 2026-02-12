package org.demo.documentation.fields.multivaluehover.color;

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
public class MyEntity225 extends BaseEntity {

	@JoinTable(name = "MyEntity225_MyEntity226",
			joinColumns = @JoinColumn(name = "MyEntity225_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity226_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity226> customFieldList = new ArrayList<>();

}