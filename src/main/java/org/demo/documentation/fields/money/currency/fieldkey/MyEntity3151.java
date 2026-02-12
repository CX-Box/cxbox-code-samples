package org.demo.documentation.fields.money.currency.fieldkey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.money.currency.fieldkey.enums.CustomFieldCurrencyDictionaryEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3151 extends BaseEntity {

	@Column
	private Double customField;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldCurrencyDictionaryEnum customFieldCurrencyDictionary;
}