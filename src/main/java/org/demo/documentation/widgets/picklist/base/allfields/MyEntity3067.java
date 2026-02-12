package org.demo.documentation.widgets.picklist.base.allfields;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picklist.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.picklist.base.allfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067Multi;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.MyEntity3067Pick;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3067 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity3067Pick customFieldEntity;
	@JoinColumn(name = "CUSTOM_FIELD_INLINE_PICK_LIST_ID")
	@ManyToOne
	private MyEntity3067Pick customFieldInlinePickListEntity;
	@JoinTable(name = "MyEntity3067_MyEntity3067MultiPick",
			joinColumns = @JoinColumn(name = "MyEntity3067_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3067Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3067Multi> customFieldMultivalueList = new ArrayList<>();
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldRadioEnum customFieldRadio;
	@Column
	private String customFieldFileUploade;
	@Column
	private String customFieldFileUploadeId;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;
}