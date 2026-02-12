package org.demo.documentation.widgets.form.colortitle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.form.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.form.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3031;
import org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3032;
import org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3037;
import org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3038;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3026 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldText;
	@JoinColumn(name = "CUSTOM_FIELD_COLOR_INLINE_PICKLIST_ID")
	@ManyToOne
	private MyEntity3031 customFieldColorInlinePicklistEntity;
	@JoinColumn(name = "CUSTOM_FIELD_COLOR_PICKLIST_ID")
	@ManyToOne
	private MyEntity3032 customFieldColorPicklistEntity;
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

	@JoinTable(name = "MyEntity3026_MyEntity3037",
			joinColumns = @JoinColumn(name = "MyEntity3026_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3037_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3037> customFieldColorMultivalueHoverList = new ArrayList<>();
	@JoinTable(name = "MyEntity3026_MyEntity3038",
			joinColumns = @JoinColumn(name = "MyEntity3026_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3038_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3038> customFieldColorMultivalueList = new ArrayList<>();
}