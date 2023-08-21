package org.demo.documentation.multivalue.required;

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
public class MyEntity188 extends BaseEntity {

	@JoinTable(name = "MyEntity188_MyEntity189",
			joinColumns = @JoinColumn(name = "MyEntity188_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity189_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity189> customFieldList = new ArrayList<>();

}