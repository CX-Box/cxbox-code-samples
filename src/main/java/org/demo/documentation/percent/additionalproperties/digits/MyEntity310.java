package org.demo.documentation.percent.additionalproperties.digits;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
// 310
// 310
//  ",

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity310 extends BaseEntity {

	@Column
	private Double customField;

}