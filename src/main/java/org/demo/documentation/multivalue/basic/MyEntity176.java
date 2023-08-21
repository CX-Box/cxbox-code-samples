package org.demo.documentation.multivalue.basic;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class MyEntity176 extends BaseEntity {

	@JoinTable(name = "MyEntity176_MyEntity177",
			joinColumns = @JoinColumn(name = "MyEntity176_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity177_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity177> customFieldList = new ArrayList<>();

	@Column
	private String customFieldAdditional;

}