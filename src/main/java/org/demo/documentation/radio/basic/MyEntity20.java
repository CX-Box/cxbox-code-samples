package org.demo.documentation.radio.basic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.radio.basic.enums.CustomFieldEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity20 extends BaseEntity {

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldEnum customField;

}