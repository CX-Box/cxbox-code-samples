package org.demo.documentation.other.alltypes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dictionary.LOV;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.alltypes.enums.DictionaryTypeEnum;
import org.demo.documentation.other.alltypes.enums.MultipleTypeEnum;
import org.demo.documentation.other.alltypes.enums.RadioTypeEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity421 extends BaseEntity {

	@Column
	private String customField;

	@Column
	private String customField2;

	@Column
	private String customField3;

	@Column
	private String customF9ield3;

	@Column
	private String customFieldForceActive;

	@Column
	private String customFieldForceActive3;

	@Column
	private String customFieldForceActive2;

	@Column
	private String inputField;
	@Column
	private String hiddenType;
	@Column
	private String textType;
	@Column
	private LocalDateTime dateTimeType;
	@Column
	private Boolean checkboxType;
	@Column
	private LocalDateTime dateType;
	@Column
	private LocalDateTime dateTimeWithSecondsType;
	@Enumerated(value = EnumType.STRING)
	@Column
	private DictionaryTypeEnum dictionaryType;
	@Column
	private String fileUploadType;
	@Column
	private String fileUploadTypeId;
	@Column
	private Long numberType;
	@Column
	private LOV dictionaryTypeLov;
	@Column
	private Double numberTypeDouble;
	@Column
	private Long percentType;
	@Column
	private Double percentTypeDouble;
	@Column
	private Double moneyType;
	@Enumerated(value = EnumType.STRING)
	@Column
	private RadioTypeEnum radioType;
	@Column
	private LOV radioTypeLov;
	@JoinColumn(name = "PICKLIST_TYPE_ID")
	@ManyToOne
	private MyEntity422 picklistTypeEntity;
	@JoinColumn(name = "INLINEPICKLIST_TYPE_ID")
	@ManyToOne
	private MyEntity423 inlinepicklistTypeEntity;
	@Enumerated(value = EnumType.STRING)
	@CollectionTable(name = "MULTIPLE_TYPE", joinColumns = @JoinColumn(name = "MyEntity421_ID"))
	@ElementCollection(targetClass = MultipleTypeEnum.class)
	@Column(name = "VALUE", nullable = false)
	private Set<MultipleTypeEnum> multipleType = new HashSet<>();
	@JoinTable(name = "MyEntity421_MyEntity422",
			joinColumns = @JoinColumn(name = "MyEntity421_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity422_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity422> multivalueTypeList = new ArrayList<>();
	@Column
	private String hintType;
	@JoinTable(name = "MyEntity421_MyEntity424",
			joinColumns = @JoinColumn(name = "MyEntity421_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity424_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity424> multihoverTypeList = new ArrayList<>();
}