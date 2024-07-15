package org.demo.documentation.fields.multivaluehover.filtration;

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
public class MyEntity233 extends BaseEntity {

	@JoinTable(name = "MyEntity233_MyEntity234",
			joinColumns = @JoinColumn(name = "MyEntity233_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity234_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity234> customFieldList = new ArrayList<>();

}