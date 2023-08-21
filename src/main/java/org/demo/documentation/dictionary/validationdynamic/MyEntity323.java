package org.demo.documentation.dictionary.validationdynamic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.dictionary.validationdynamic.enums.CustomFieldEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity323 extends BaseEntity {

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldEnum customField;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldEnum customFieldAdditional;

}