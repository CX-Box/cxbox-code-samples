package org.demo.documentation.multivaluero.validationconfirm;

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
public class MyEntity220 extends BaseEntity {

	@JoinTable(name = "MyEntity220_MyEntity223",
			joinColumns = @JoinColumn(name = "MyEntity220_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity223_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity223> customFieldList = new ArrayList<>();

}