package org.demo.documentation.widgets.list.base.allfields;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import org.demo.documentation.widgets.list.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.list.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.list.base.allfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.list.base.allfields.forfields.MyEntity3002Multi;
import org.demo.documentation.widgets.list.base.allfields.forfields.MyEntity3002Multi2;
import org.demo.documentation.widgets.list.base.allfields.forfields.MyEntity3002Pick;
import org.demo.documentation.widgets.list.base.allfields.forfields.MyEntity3002Pick2;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3002 extends BaseEntity {

    @Column
    private String customField;

    @Column
    private String customFieldHidden;
    @Column
    private String customFieldText;
    @Column
    private LocalDateTime customFieldDateTime;
    @Column
    private Boolean customFieldCheckbox;
    @Column
    private LocalDateTime customFieldDate;
    @Column
    private LocalDateTime customFieldDateTimeWithSeconds;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;
    @Column
    private String customFieldFileUpload;
    @Column
    private String customFieldFileUploadId;
    @Column
    private Long customFieldNumber;
    @Column
    private Long customFieldPercent;
    @Column
    private Double customFieldMoney;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldRadioEnum customFieldRadio;
    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
    @ManyToOne
    private MyEntity3002Pick2 customFieldPickListEntity;
    @JoinColumn(name = "CUSTOM_FIELD_INLINE_ID")
    @ManyToOne
    private MyEntity3002Pick customFieldInlineEntity;
    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT_3002", joinColumns = @JoinColumn(name = "MyEntity3002_ID"))
    @ElementCollection(targetClass = CustomFieldMultipleSelectEnum.class)
    @Column(name = "VALUE", nullable = false)
    private Set<CustomFieldMultipleSelectEnum> customFieldMultipleSelect = new HashSet<>();
    @JoinTable(name = "MyEntity3002_MyEntity3003_2",
            joinColumns = @JoinColumn(name = "MyEntity3002_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3003_id")
    )
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<MyEntity3002Multi2> customFieldMultivalueList = new ArrayList<>();
    @Column
    private String customFieldHint;
    @JoinTable(name = "MyEntity3002_MyEntity3002Multi_2",
            joinColumns = @JoinColumn(name = "MyEntity3002_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3002Multi_id")
    )
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<MyEntity3002Multi> customFieldMultivalueHoverList = new ArrayList<>();
}