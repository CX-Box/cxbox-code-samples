package org.demo.documentation.widgets.picklist.colortitle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picklist.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.picklist.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061Multi;
import org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061MultiMulti;
import org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061Pick;
import org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061PickPick;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3061 extends BaseEntity {
	@Column
	private String customField;
	@JoinTable(name = "MyEntity3061_MyEntity3061Multi",
			joinColumns = @JoinColumn(name = "MyEntity3061_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3061Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3061Multi> customFieldColorMultivalueHoverList = new ArrayList<>();
	@JoinTable(name = "MyEntity3061_MyEntity3061MultiMulti",
			joinColumns = @JoinColumn(name = "MyEntity3061_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3061MultiMulti_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3061MultiMulti> customFieldColorMultivalueList = new ArrayList<>();
	@JoinColumn(name = "CUSTOM_FIELD_COLOR_INLINE_PICKLIST_ID")
	@ManyToOne
	private MyEntity3061Pick customFieldColorInlinePicklistEntity;
	@JoinColumn(name = "CUSTOM_FIELD_COLOR_PICKLIST_ID")
	@ManyToOne
	private MyEntity3061PickPick customFieldColorPicklistEntity;
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
}