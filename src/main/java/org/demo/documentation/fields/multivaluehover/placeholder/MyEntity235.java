package org.demo.documentation.fields.multivaluehover.placeholder;

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
public class MyEntity235 extends BaseEntity {

	@Column
	private Double customField;

	@JoinTable(name = "MyEntity235_MyEntityMulti235Pick",
			joinColumns = @JoinColumn(name = "MyEntity235_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntityMulti235_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntityMulti235> customFieldMultivalueHoverList = new ArrayList<>();
}