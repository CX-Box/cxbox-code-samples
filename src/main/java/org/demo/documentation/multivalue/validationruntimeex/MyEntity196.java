package org.demo.documentation.multivalue.validationruntimeex;

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
public class MyEntity196 extends BaseEntity {

	@JoinTable(name = "MyEntity196_MyEntity197",
			joinColumns = @JoinColumn(name = "MyEntity196_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity197_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity197> customFieldList = new ArrayList<>();

}