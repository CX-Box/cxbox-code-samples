package org.demo.documentation.fields.multivalue.sorting;

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
public class MyEntity190 extends BaseEntity {

	@JoinTable(name = "MyEntity190_MyEntity191",
			joinColumns = @JoinColumn(name = "MyEntity190_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity191_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity191> customFieldList = new ArrayList<>();

}