package org.demo.documentation.other.forceactive2.allfields;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.forceactive2.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.other.forceactive2.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.other.forceactive2.allfields.enums.CustomFieldRadioEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity4902 extends BaseEntity {
    @Column
    private String customField;
    @JoinTable(name = "MyEntity4902_MyEntity4902MultiHoverPick",
            joinColumns = @JoinColumn(name = "MyEntity4902_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity4902MultiHover_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity4902MultiHover> customFieldMultivalueHoverList = new ArrayList<>();
    @Column
    private String customFieldHint;
    @JoinTable(name = "MyEntity4902_MyEntity4902MultiPick",
            joinColumns = @JoinColumn(name = "MyEntity4902_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity4902Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity4902Multi> customFieldMultivalueList = new ArrayList<>();
    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT_MYEXAMPLE4902_2", joinColumns = @JoinColumn(name = "MyEntity4902_ID"))
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
    private MyEntity4902PickInline customFieldInlineEntity;
    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
    @ManyToOne
    private MyEntity4902Pick customFieldPickListEntity;
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
    @JoinTable(name = "MyEntity4902_MyEntity4902MultiPick0",
            joinColumns = @JoinColumn(name = "MyEntity4902_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity4902Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity4902Multi> customFieldMultivalueNewList = new ArrayList<>();
    @JoinColumn(name = "SUGGESTION_PICK_LIST_ID")
    @ManyToOne
    private MyEntity4902Suggection suggestionPickListEntity;
}
