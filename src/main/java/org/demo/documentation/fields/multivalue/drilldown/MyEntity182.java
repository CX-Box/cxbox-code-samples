package org.demo.documentation.fields.multivalue.drilldown;

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
public class MyEntity182 extends BaseEntity {

	@JoinTable(name = "MyEntity182_MyEntity183",
			joinColumns = @JoinColumn(name = "MyEntity182_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity183_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity183> customFieldList = new ArrayList<>();

}