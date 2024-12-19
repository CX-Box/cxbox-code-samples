package org.demo.documentation.widgets.additionallist.base.allfields;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.additionallist.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.additionallist.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.additionallist.base.allfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.additionallist.base.allfields.forfields.MyEntity3191Multi;
import org.demo.documentation.widgets.additionallist.base.allfields.forfields.MyEntity3191MultiHover;
import org.demo.documentation.widgets.additionallist.base.allfields.forfields.MyEntity3191Pick;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// 3191
// 3191
// 3191

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3191 extends BaseEntity {
    @Column
    private String customField;
    @JoinTable(name = "MyEntity3191_MyEntity3191MultiHoverPick",
            joinColumns = @JoinColumn(name = "MyEntity3191_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3191MultiHover_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3191MultiHover> customFieldMultivalueHoverDisplayedKeyList = new ArrayList<>();
    @Column
    private String customFieldHint;
    @JoinTable(name = "MyEntity3191_MyEntity3191MultiPick",
            joinColumns = @JoinColumn(name = "MyEntity3191_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3191Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3191Multi> customFieldMultivalueList = new ArrayList<>();
    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT_3191", joinColumns = @JoinColumn(name = "MyEntity3191_ID"))
    @ElementCollection(targetClass = CustomFieldMultipleSelectEnum.class)
    @Column(name = "VALUE", nullable = false)
    private Set<CustomFieldMultipleSelectEnum> customFieldMultipleSelect = new HashSet<>();
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldRadioEnum customFieldRadio;
    @Column
    private Double customFieldMoney;
    @JoinColumn(name = "CUSTOM_FIELD_INLINE_ID")
    @ManyToOne
    private MyEntity3191Pick customFieldInlineEntity;
    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
    @ManyToOne
    private MyEntity3191Pick customFieldPickListEntity;
    @Column
    private Long customFieldPercent;
    @Column
    private Long customFieldNumber;
    @Column
    private String customFieldFileUpload;
    @Column
    private String customFieldFileUploadId;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;
    @Column
    private LocalDateTime customFieldDateTimeWithSeconds;
    @Column
    private LocalDateTime customFieldDate;
    @Column
    private Boolean customFieldCheckbox;
    @Column
    private LocalDateTime customFieldDateTime;
    @Column
    private String customFieldHidden;
    @Column
    private String customFieldText;
}