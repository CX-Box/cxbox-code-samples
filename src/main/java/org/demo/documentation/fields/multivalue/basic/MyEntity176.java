package org.demo.documentation.fields.multivalue.basic;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;


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