package org.demo.documentation.additional.forceactiveshowcondition;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.additional.forceactiveshowcondition.enums.CrsStatusEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity1432 extends BaseEntity {

	@Enumerated(value = EnumType.STRING)
	@Column
	private CrsStatusEnum crsStatus;

	@Column
	private Boolean accountableCrs;

}
