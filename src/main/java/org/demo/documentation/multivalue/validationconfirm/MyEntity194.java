package org.demo.documentation.multivalue.validationconfirm;

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
public class MyEntity194 extends BaseEntity {

	@JoinTable(name = "MyEntity194_MyEntity195",
			joinColumns = @JoinColumn(name = "MyEntity194_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity195_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity195> customFieldList = new ArrayList<>();

}