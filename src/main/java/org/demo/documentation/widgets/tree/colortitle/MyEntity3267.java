package org.demo.documentation.widgets.tree.colortitle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.tree.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267InlinePicklist;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267Multi;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267MultiMulti;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267Picklist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3267 extends BaseEntity {
	@Column
	private String customFieldText;
	@Column
	private String customField;
	@JoinTable(name = "MyEntity3267_MyEntity3267Multi",
			joinColumns = @JoinColumn(name = "MyEntity3267_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3267Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3267Multi> customFieldColorMultivalueHoverTree = new ArrayList<>();
	@JoinTable(name = "MyEntity3267_MyEntity3267MultiMulti",
			joinColumns = @JoinColumn(name = "MyEntity3267_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3267MultiMulti_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3267MultiMulti> customFieldColorMultivalueTree = new ArrayList<>();
	@JoinColumn(name = "CUSTOM_FIELD_COLOR_INLINE_PICKLIST_ID")
	@ManyToOne
	private MyEntity3267InlinePicklist customFieldColorInlinePicklistEntity;
	@JoinColumn(name = "CUSTOM_FIELD_COLOR_PICKLIST_ID")
	@ManyToOne
	private MyEntity3267Picklist customFieldColorPicklistEntity;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldColorRadioEnum customFieldColorRadio;
	@Column
	private Double customFieldColorMoney;
	@Column
	private Long customFieldColorPercent;
	@Column
	private Long customFieldColorNumber;
	@Column
	private String customFieldColorFileUploade;
	@Column
	private String customFieldColorFileUploadeId;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldColorDictionaryEnum customFieldColorDictionary;
	@Column
	private LocalDateTime customFieldColorDateTimeWithSeconds;
	@Column
	private LocalDateTime customFieldColorDate;
	@Column
	private Boolean customFieldColorCheckbox;
	@Column
	private LocalDateTime customFieldColorDateTime;
	@Column
	private String customFieldColorText;
	@Column
	private String customFieldColorInput;
}