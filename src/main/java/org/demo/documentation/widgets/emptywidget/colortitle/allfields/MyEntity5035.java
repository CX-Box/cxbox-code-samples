package org.demo.documentation.widgets.emptywidget.colortitle.allfields;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.enums.CustomFieldRadioEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity5035 extends BaseEntity {
    @Column
    private String customField;

    @JoinTable(name = "MyEntity5035_MyEntity5035MutiPick",
            joinColumns = @JoinColumn(name = "MyEntity5035_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity5035Muti_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity5035Muti> customFieldMultivalueHoverList = new ArrayList<>();

    @Column
    private String customFieldHint;

    @JoinTable(name = "MyEntity5035_MyEntity5035MutiPick0",
            joinColumns = @JoinColumn(name = "MyEntity5035_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity5035Muti_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity5035Muti> customFieldMultivalueList = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT_MYEXAMPLE5035", joinColumns = @JoinColumn(name = "MyEntity5035_ID"))
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
    private MyEntity5035Pick customFieldInlineEntity;

    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
    @ManyToOne
    private MyEntity5035Pick customFieldPickListEntity;

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
