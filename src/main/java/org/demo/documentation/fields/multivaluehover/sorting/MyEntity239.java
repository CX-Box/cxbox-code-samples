package org.demo.documentation.fields.multivaluehover.sorting;

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
public class MyEntity239 extends BaseEntity {

	@JoinTable(name = "MyEntity239_MyEntity240",
			joinColumns = @JoinColumn(name = "MyEntity239_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity240_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity240> customFieldList = new ArrayList<>();

}