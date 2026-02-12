package org.demo.documentation.widgets.property.sethidden;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity5019 extends BaseEntity {
	@Column
	private String customField;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;

	@JoinTable(name = "MyEntity5019_MyEntity5019MultiPick",
			joinColumns = @JoinColumn(name = "MyEntity5019_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity5019Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity5019Multi> customFieldMVList = new ArrayList<>();

	@JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
	@ManyToOne
	private MyEntity5019Pick customFieldPickListEntity;
}
