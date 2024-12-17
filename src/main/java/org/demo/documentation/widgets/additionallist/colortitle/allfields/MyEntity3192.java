package org.demo.documentation.widgets.additionallist.colortitle.allfields;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields.MyEntity3192Multi;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields.MyEntity3192MultiHover;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields.MyEntity3192Pick;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3192 extends BaseEntity {
    @Column
    private String customField;
    @JoinTable(name = "MyEntity3192_MyEntity3192MultiHoverPick",
            joinColumns = @JoinColumn(name = "MyEntity3192_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3192MultiHover_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3192MultiHover> customFieldMultivalueHoverDisplayedKeyList = new ArrayList<>();
    @Column
    private String customFieldHint;
    @JoinTable(name = "MyEntity3192_MyEntity3192MultiPick",
            joinColumns = @JoinColumn(name = "MyEntity3192_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3192Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3192Multi> customFieldMultivalueList = new ArrayList<>();
    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT_3192", joinColumns = @JoinColumn(name = "MyEntity3192_ID"))
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
    private MyEntity3192Pick customFieldInlineEntity;
    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
    @ManyToOne
    private MyEntity3192Pick customFieldPickListEntity;
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
    private String customFieldText;
    @Column
    private String customFieldHidden;
}