package org.demo.documentation.dictionary.validationannotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.dictionary.validationannotation.enums.CustomFieldEnum;
// 293
// 293
//  293",

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity293 extends BaseEntity {

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldEnum customField;

}