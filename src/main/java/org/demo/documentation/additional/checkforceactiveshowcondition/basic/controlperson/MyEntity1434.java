package org.demo.documentation.additional.checkforceactiveshowcondition.basic.controlperson;

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
public class MyEntity1434 extends BaseEntity {

	@Column
	private String fullName;

	@Column
	private String inn;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private MyEntity1432 parentEntity;

}
