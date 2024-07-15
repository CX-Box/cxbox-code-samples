package org.demo.documentation.fields.multivaluehover.ro;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


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