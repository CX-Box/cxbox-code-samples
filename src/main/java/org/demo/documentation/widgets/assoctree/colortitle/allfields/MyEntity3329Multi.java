package org.demo.documentation.widgets.assoctree.colortitle.allfields;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329MultiAssoc;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329MultiMultiAssoc;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329Picklist;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329PicklistAssoc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3329Multi extends BaseEntity {
	@Column
	private String customField;
	@JoinTable(name = "MyEntity3329Multi_MyEntity3329MultiAssoc",
			joinColumns = @JoinColumn(name = "MyEntity3329Multi_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3329MultiAssoc_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3329MultiAssoc> customFieldColorMultivalueHoverList = new ArrayList<>();
	@JoinTable(name = "MyEntity3329Multi_MyEntity3329MultiMultiAssoc",
			joinColumns = @JoinColumn(name = "MyEntity3329Multi_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3329MultiMultiAssoc_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3329MultiMultiAssoc> customFieldColorMultivalueList = new ArrayList<>();
	@JoinColumn(name = "CUSTOM_FIELD_COLOR_INLINE_PICKLIST_ID")
	@ManyToOne
	private MyEntity3329Picklist customFieldColorInlinePicklistEntity;
	@JoinColumn(name = "CUSTOM_FIELD_COLOR_PICKLIST_ID")
	@ManyToOne
	private MyEntity3329PicklistAssoc customFieldColorPicklistEntity;
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

	@Column
	private Long parentId;

	@OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
	private List<MyEntity3329Multi> children = new ArrayList<>();

}
