package org.demo.documentation.multivaluero.required;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity214 extends BaseEntity {

	@JoinTable(name = "MyEntity214_MyEntity215",
			joinColumns = @JoinColumn(name = "MyEntity214_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity215_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity215> customFieldList = new ArrayList<>();

}