package org.demo.documentation.multivalue.validationconfirm;

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
public class MyEntity194 extends BaseEntity {

	@JoinTable(name = "MyEntity194_MyEntity195",
			joinColumns = @JoinColumn(name = "MyEntity194_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity195_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity195> customFieldList = new ArrayList<>();

}