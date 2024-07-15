package org.demo.documentation.fields.multivalue.colorconst;

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
public class MyEntity178 extends BaseEntity {

	@JoinTable(name = "MyEntity178_MyEntity179",
			joinColumns = @JoinColumn(name = "MyEntity178_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity179_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity179> customFieldList = new ArrayList<>();

}