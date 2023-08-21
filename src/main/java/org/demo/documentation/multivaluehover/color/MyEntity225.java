package org.demo.documentation.multivaluehover.color;

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
public class MyEntity225 extends BaseEntity {

	@JoinTable(name = "MyEntity225_MyEntity226",
			joinColumns = @JoinColumn(name = "MyEntity225_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity226_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity226> customFieldList = new ArrayList<>();

}