package org.demo.documentation.widgets.tree.any.data.departments;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.any.data.users.My3261Users;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "MYDEPARTMENTS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class Mydepartments extends BaseEntity {


	@Column
	private String departmentName;

	@Column
	private String description;

	@Column
	private Long parentId;

	@JoinTable(name = "Mydepartments_My3261UsersPick",
			joinColumns = @JoinColumn(name = "Mydepartments_id"),
			inverseJoinColumns = @JoinColumn(name = "My3261Users_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<My3261Users> fullNameList = new ArrayList<>();
}