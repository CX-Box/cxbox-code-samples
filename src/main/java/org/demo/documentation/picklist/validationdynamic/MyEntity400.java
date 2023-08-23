package org.demo.documentation.picklist.validationdynamic;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
// 400
// 400
//  ",

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity400 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity401Pick customFieldEntity;

}