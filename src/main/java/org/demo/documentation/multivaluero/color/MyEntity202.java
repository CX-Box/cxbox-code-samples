package org.demo.documentation.multivaluero.color;

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
public class MyEntity202 extends BaseEntity {

	@JoinTable(name = "MyEntity202_MyEntity203",
			joinColumns = @JoinColumn(name = "MyEntity202_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity203_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity203> customFieldList = new ArrayList<>();

}