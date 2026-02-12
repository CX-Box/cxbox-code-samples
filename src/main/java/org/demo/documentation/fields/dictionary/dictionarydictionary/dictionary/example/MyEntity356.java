package org.demo.documentation.fields.dictionary.dictionarydictionary.dictionary.example;

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
public class MyEntity356 extends BaseEntity {
	@Column
	private String customField;

	@Column
	private ClientImportance customFieldDictionary;
}