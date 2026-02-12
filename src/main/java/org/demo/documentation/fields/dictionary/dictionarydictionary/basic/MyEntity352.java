package org.demo.documentation.fields.dictionary.dictionarydictionary.basic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity352 extends BaseEntity {
	@Column
	private String customField;

	@Column
	private Regions customFieldDictionary;
}