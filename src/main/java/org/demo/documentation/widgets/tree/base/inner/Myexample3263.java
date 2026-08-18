package org.demo.documentation.widgets.tree.base.inner;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.data.inner.Myexample3261;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "MYEXAMPLE3263")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class Myexample3263 extends BaseEntity {


	@JoinColumn(name = "DEPARTMENT_ID")
	@ManyToOne
	private Myexample3261 departmentEntity;

	@JoinTable(name = "Myexample3263_Myexample3261Pick0",
			joinColumns = @JoinColumn(name = "Myexample3263_id"),
			inverseJoinColumns = @JoinColumn(name = "Myexample3261_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<Myexample3261> departmentsList = new ArrayList<>();
}