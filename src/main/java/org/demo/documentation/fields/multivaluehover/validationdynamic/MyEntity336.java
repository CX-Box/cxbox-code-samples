package org.demo.documentation.fields.multivaluehover.validationdynamic;

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
public class MyEntity336 extends BaseEntity {

	@JoinTable(name = "MyEntity336_MyEntity339Pick",
			joinColumns = @JoinColumn(name = "MyEntity336_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity339_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity339> customFieldMultiHolderList = new ArrayList<>();
}