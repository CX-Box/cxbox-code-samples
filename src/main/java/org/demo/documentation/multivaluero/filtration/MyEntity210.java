package org.demo.documentation.multivaluero.filtration;

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
public class MyEntity210 extends BaseEntity {

	@JoinTable(name = "MyEntity210_MyEntity211",
			joinColumns = @JoinColumn(name = "MyEntity210_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity211_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity211> customFieldList = new ArrayList<>();

}