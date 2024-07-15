package org.demo.documentation.fields.multivalue.basic;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
public class MyEntity176 extends BaseEntity {

	@JoinTable(name = "MyEntity176_MyEntity177",
			joinColumns = @JoinColumn(name = "MyEntity176_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity177_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntityMultivalue177> customFieldList = new ArrayList<>();

	@Column
	private String customFieldAdditional;

}