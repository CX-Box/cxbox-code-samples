package org.demo.documentation.widgets.form.base.allfields;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010Multi;
import org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHover;
import org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010Pick;
import org.demo.documentation.widgets.form.base.allfields.forfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.form.base.allfields.forfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.form.base.allfields.forfields.enums.CustomFieldRadioEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3010 extends BaseEntity {
    @Column
    private String customField;
    @JoinTable(name = "MyEntity3010_MyEntity3010MultiHoverPick",
            joinColumns = @JoinColumn(name = "MyEntity3010_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3010MultiHover_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3010MultiHover> customFieldMultivalueHoverList = new ArrayList<>();
    @Column
    private String customFieldHint;
    @JoinTable(name = "MyEntity3010_MyEntity3010MultiPick",
            joinColumns = @JoinColumn(name = "MyEntity3010_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3010Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3010Multi> customFieldMultivalueList = new ArrayList<>();
    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT3010", joinColumns = @JoinColumn(name = "MyEntity3010_ID"))
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
    private MyEntity3010Pick customFieldInlineEntity;
    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
    @ManyToOne
    private MyEntity3010Pick customFieldPickListEntity;
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