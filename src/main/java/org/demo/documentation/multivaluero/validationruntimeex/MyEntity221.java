package org.demo.documentation.multivaluero.validationruntimeex;

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
public class MyEntity221 extends BaseEntity {

	@JoinTable(name = "MyEntity221_MyEntity222",
			joinColumns = @JoinColumn(name = "MyEntity221_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity222_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity222> customFieldList = new ArrayList<>();

}