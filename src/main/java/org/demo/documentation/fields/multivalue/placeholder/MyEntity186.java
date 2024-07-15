package org.demo.documentation.fields.multivalue.placeholder;

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
public class MyEntity186 extends BaseEntity {

	@JoinTable(name = "MyEntity186_MyEntity187",
			joinColumns = @JoinColumn(name = "MyEntity186_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity187_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity187> customFieldList = new ArrayList<>();

}