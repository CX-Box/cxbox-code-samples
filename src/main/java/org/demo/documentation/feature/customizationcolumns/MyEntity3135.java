package org.demo.documentation.feature.customizationcolumns;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.customizationcolumns.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.feature.customizationcolumns.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.feature.customizationcolumns.enums.CustomFieldMultipleSelectEnum1;
import org.demo.documentation.feature.customizationcolumns.enums.CustomFieldRadioEnum;
import org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135InlinePick;
import org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135Multi;
import org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135MultiHover;
import org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135Pick;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3135 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customFieldInput;
    @Column
    private LocalDateTime customFieldDate;
    @Column
    private Boolean customFieldCheckBox;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;

    @Column
    private String customFieldHint;

    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldRadioEnum customFieldRadio;
    @Column
    private Double customFieldMoney;
    @JoinColumn(name = "CUSTOM_FIELD_INLINE_ID")
    @ManyToOne
    private MyEntity3135InlinePick customFieldInlineEntity;
    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
    @ManyToOne
    private MyEntity3135Pick customFieldPickListEntity;
    @Column
    private Long customFieldPercent;
    @Column
    private Long customFieldNumber;
    @Column
    private String customFieldFileUpload;
    @Column
    private String customFieldFileUploadId;
    @Column
    private LocalDateTime customFieldDateTimeWithSeconds;
    @Column
    private LocalDateTime customFieldDateTime;
    @Column
    private String customFieldText;
    @Column
    private String customFieldHidden;
    @JoinTable(name = "MyEntity3135_MyEntity3135Multi",
            joinColumns = @JoinColumn(name = "MyEntity3135_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3135Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3135Multi> customFieldMultivalueList = new ArrayList<>();
    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT_3135", joinColumns = @JoinColumn(name = "MyEntity3135_ID"))
    @ElementCollection(targetClass = CustomFieldMultipleSelectEnum.class)
    @Column(name = "VALUE", nullable = false)
    private Set<CustomFieldMultipleSelectEnum> customFieldMultipleSelect = new HashSet<>();
    @JoinTable(name = "MyEntity3135_MyEntity3135MultiHover",
            joinColumns = @JoinColumn(name = "MyEntity3135_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3135MultiHover_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3135MultiHover> customFieldMultivalueHoverList = new ArrayList<>();
}