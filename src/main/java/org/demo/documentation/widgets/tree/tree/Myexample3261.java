package org.demo.documentation.widgets.tree.tree;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


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
	private Boolean isLeaf;

}