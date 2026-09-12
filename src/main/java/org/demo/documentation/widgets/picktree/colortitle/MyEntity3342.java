package org.demo.documentation.widgets.picktree.colortitle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picktree.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.picktree.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342Multi;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342MultiMulti;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342Pick;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342PickPick;

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
public class MyEntity3342 extends BaseEntity {
	@Column
	private String customField;
	@JoinTable(name = "MyEntity3342_MyEntity3342Multi",
			joinColumns = @JoinColumn(name = "MyEntity3342_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3342Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3342Multi> customFieldColorMultivalueHoverList = new ArrayList<>();
	@JoinTable(name = "MyEntity3342_MyEntity3342MultiMulti",
			joinColumns = @JoinColumn(name = "MyEntity3342_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3342MultiMulti_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3342MultiMulti> customFieldColorMultivalueList = new ArrayList<>();
	@JoinColumn(name = "CUSTOM_FIELD_COLOR_INLINE_PICKLIST_ID")
	@ManyToOne
	private MyEntity3342Pick customFieldColorInlinePicktreeEntity;
	@JoinColumn(name = "CUSTOM_FIELD_COLOR_PICKLIST_ID")
	@ManyToOne
	private MyEntity3342PickPick customFieldColorPicktreeEntity;
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
	private String customFieldColorInputConst;
	@Column
	private String customFieldColorTextConst;

	@Column
	private Long parentId;

	@OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
	private List<MyEntity3342> children = new ArrayList<>();

}
