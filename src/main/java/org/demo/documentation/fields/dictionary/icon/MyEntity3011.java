package org.demo.documentation.fields.dictionary.icon;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3011Multi;
import org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3012Multi;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.fields.dictionary.icon.picklistpopup.MyEntity3012;
import org.demo.documentation.fields.dictionary.icon.picklistpopup.MyEntity3013;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3011 extends BaseEntity {
	@Column
	private String customField;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;

	@JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
	@ManyToOne
	private MyEntity3012 customFieldPickListEntity;
	@JoinColumn(name = "CUSTOM_FIELD_DICTIONARY_INLINE_PICK_LIST_ID")
	@ManyToOne
	private MyEntity3013 customFieldDictionaryInlinePickListEntity;
	@JoinTable(name = "MyEntity3011_MyEntity3011MultiPick",
			joinColumns = @JoinColumn(name = "MyEntity3011_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3011Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3011Multi> customFieldMultivalueList = new ArrayList<>();
	@JoinTable(name = "MyEntity3011_MyEntity3012MultiPick",
			joinColumns = @JoinColumn(name = "MyEntity3011_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3012Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3012Multi> customFieldMultivalueModeIconList = new ArrayList<>();
}