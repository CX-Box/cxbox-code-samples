package org.demo.documentation.additional.checkforceactiveshowcondition.basic.taxresidency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.MyEntity1432;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity1433 extends BaseEntity {

	@Column
	private String country;

	@Column
	private String tin;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private MyEntity1432 parentEntity;

}
