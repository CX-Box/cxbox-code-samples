package org.demo.documentation.fields.dictionary.dictionarydictionary.filtration;

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
public class MyEntity358 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private CustomDictionaryFiltration customFieldDictionary;
	@Column
	private CustomDictionaryNewFiltration customFieldNewDictionary;
	@Column
	private CustomDictionaryFiltrationSecond customFieldDictionarySecond;
}