package org.demo.documentation.fields.dictionary.filtration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.dictionary.filtration.enums.CustomFieldEnum;
import org.demo.documentation.fields.dictionary.filtration.enums.CustomFieldNewEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity87 extends BaseEntity {

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldEnum customField;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldNewEnum customFieldNew;

}