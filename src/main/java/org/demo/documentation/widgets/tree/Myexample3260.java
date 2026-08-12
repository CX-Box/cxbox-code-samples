package org.demo.documentation.widgets.tree;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.tree.Myexample3261;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "MYEXAMPLE3260")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class Myexample3260 extends BaseEntity {


	@JoinColumn(name = "DEPARTMENT_ID")
	@ManyToOne
	private Myexample3261 departmentEntity;

	@JoinTable(name = "Myexample3260_Myexample3261Pick0",
			joinColumns = @JoinColumn(name = "Myexample3260_id"),
			inverseJoinColumns = @JoinColumn(name = "Myexample3261_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<Myexample3261> departmentsList = new ArrayList<>();
}