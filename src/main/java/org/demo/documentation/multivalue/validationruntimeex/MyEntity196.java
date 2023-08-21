package org.demo.documentation.multivalue.validationruntimeex;

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
public class MyEntity196 extends BaseEntity {

	@JoinTable(name = "MyEntity196_MyEntity197",
			joinColumns = @JoinColumn(name = "MyEntity196_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity197_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity197> customFieldList = new ArrayList<>();

}