package org.demo.documentation.multivalue.filtration;

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
public class MyEntity184 extends BaseEntity {

	@JoinTable(name = "MyEntity184_MyEntity185",
			joinColumns = @JoinColumn(name = "MyEntity184_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity185_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity185> customFieldList = new ArrayList<>();

}