package org.demo.documentation.multivalue.validationdynamic;

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
public class MyEntity335 extends BaseEntity {

	@JoinTable(name = "MyEntity335_MyEntity337",
			joinColumns = @JoinColumn(name = "MyEntity335_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity337_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity337> customFieldList = new ArrayList<>();

}