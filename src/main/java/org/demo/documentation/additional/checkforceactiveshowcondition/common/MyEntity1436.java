package org.demo.documentation.additional.checkforceactiveshowcondition.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.MyEntity1432;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.enums.CrsStatusEnum;

/**
 * Records of all the check scenarios, a bc reads only the records of its scenario
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity1436 extends BaseEntity {

	@Column
	private String scenario;

	@Column
	private String country;

	@Column
	private String tin;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CrsStatusEnum crsStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ENTITY_ID")
	private MyEntity1432 parentEntity;

	/**
	 * The parent record of the bc outside of the hierarchy of myexample1432 (myexample1447)
	 */
	@Column
	private Long ownerId;

	/**
	 * The parent node of the tree
	 */
	@Column
	private Long parentId;

	@OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
	private List<MyEntity1436> children = new ArrayList<>();

}
