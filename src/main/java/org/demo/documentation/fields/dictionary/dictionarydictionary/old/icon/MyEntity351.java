package org.demo.documentation.fields.dictionary.dictionarydictionary.old.icon;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dictionary.LOV;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity351 extends BaseEntity {
	@Column
	private String customField;

	@Column
	private LOV customFieldDictionary;

}