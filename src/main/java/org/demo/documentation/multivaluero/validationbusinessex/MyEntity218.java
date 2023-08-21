package org.demo.documentation.multivaluero.validationbusinessex;

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
public class MyEntity218 extends BaseEntity {

	@JoinTable(name = "MyEntity218_MyEntity219",
			joinColumns = @JoinColumn(name = "MyEntity218_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity219_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity219> customFieldList = new ArrayList<>();

}