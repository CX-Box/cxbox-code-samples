package org.demo.documentation.fields.multivaluehover.sorting;

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
public class MyEntity239 extends BaseEntity {

	@JoinTable(name = "MyEntity239_MyEntity240",
			joinColumns = @JoinColumn(name = "MyEntity239_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity240_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity240> customFieldList = new ArrayList<>();

}