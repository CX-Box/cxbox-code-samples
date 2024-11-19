package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175InlinePick;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175Multi;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175MultiHover;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175Pick;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.enums.CustomFieldRadioEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3175 extends BaseEntity {
    @Column
    private String customField;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;
    @Column
    private String customFieldText;
    @Column
    private Long customFieldPercent;
    @JoinTable(name = "MyEntity3175_MyEntity3175MultiHoverPick",
            joinColumns = @JoinColumn(name = "MyEntity3175_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3175MultiHover_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3175MultiHover> customFieldMultivalueHoverList = new ArrayList<>();
    @Column
    private String customFieldHint;
    @JoinTable(name = "MyEntity3175_MyEntity3175MultiPick",
            joinColumns = @JoinColumn(name = "MyEntity3175_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3175Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3175Multi> customFieldMultivalueList = new ArrayList<>();
    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT_3175", joinColumns = @JoinColumn(name = "MyEntity3175_ID"))
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
    private MyEntity3175InlinePick customFieldInlineEntity;
    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
    @ManyToOne
    private MyEntity3175Pick customFieldPickListEntity;
    @Column
    private Long customFieldNumber;
    @Column
    private String customFieldFileUpload;
    @Column
    private String customFieldFileUploadId;
    @Column
    private LocalDateTime customFieldDateTimeWithSeconds;
    @Column
    private LocalDateTime customFieldDate;
    @Column
    private String customFieldHidden;
    @Column
    private Boolean customFieldCheckbox;
    @Column
    private LocalDateTime customFieldDateTime;
}