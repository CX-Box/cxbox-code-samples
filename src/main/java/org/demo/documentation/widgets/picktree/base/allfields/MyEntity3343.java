package org.demo.documentation.widgets.picktree.base.allfields;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picktree.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.picktree.base.allfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343Multi;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.picktreepopup.MyEntity3343Pick;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3343 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity3343Pick customFieldEntity;
	@JoinColumn(name = "CUSTOM_FIELD_INLINE_PICK_LIST_ID")
	@ManyToOne
	private MyEntity3343Pick customFieldInlinePickTreeEntity;
	@JoinTable(name = "MyEntity3343_MyEntity3343MultiPick",
			joinColumns = @JoinColumn(name = "MyEntity3343_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3343Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3343Multi> customFieldMultivalueList = new ArrayList<>();
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