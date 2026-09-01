package org.demo.documentation.widgets.tree.data.inner;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.base.inner.Myexample3263;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "MYEXAMPLE3261")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class Myexample3261 extends BaseEntity {

	@Column
	private String department;

	@Column
	private Long parentId;

	@Column
	private String description;

	@Column
	private String code;

	@Column
	private String mnemonic;

	@ManyToMany(mappedBy = "departmentsList")
	private List<Myexample3263> departments = new ArrayList<>();
}