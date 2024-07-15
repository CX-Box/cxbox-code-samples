package org.demo.documentation.fields.multivaluehover.basic;

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
public class MyEntity224 extends BaseEntity {

	@JoinTable(name = "MyEntity224_MyEntity259",
			joinColumns = @JoinColumn(name = "MyEntity224_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity259_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity259> customFieldList = new ArrayList<>();

}