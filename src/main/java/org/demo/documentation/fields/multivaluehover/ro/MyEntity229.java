package org.demo.documentation.fields.multivaluehover.ro;

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
public class MyEntity229 extends BaseEntity {

	@JoinTable(name = "MyEntity229_MyEntity230",
			joinColumns = @JoinColumn(name = "MyEntity229_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity230_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity230> customFieldList = new ArrayList<>();

}