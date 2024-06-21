package org.demo.documentation.widgets.additionalinfo.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import org.demo.documentation.widgets.additionalinfo.base.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.additionalinfo.base.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.additionalinfo.base.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Multi;
import org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Pick;
import org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Pick2;
import org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Multi2;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3600 extends BaseEntity {

    @Column
    private String customField;
    @Column
    private String customField2;
    @Column
    private String customField3;
    @Column
    private String customFieldText;
    @Column
    private LocalDateTime customFieldDateTime;
    @Column
    private Boolean customFieldCheckbox;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;
    @Column
    private Long customFieldNum;
    @Column
    private Long customFieldPercent;
    @Column
    private Double customFieldMoney;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldRadioEnum customFieldRadio;
    @Column
    private LocalDateTime customFieldDateTimeWithSeconds;
    @JoinColumn(name = "CUSTOM_FIELD_INLINE_PICK_LIST_ID")
    @ManyToOne
    private MyEntity3600Pick customFieldInlinePickListEntity;
    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
    @ManyToOne
    private MyEntity3600Pick2 customFieldPickListEntity;
    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT", joinColumns = @JoinColumn(name = "MyEntity3600_ID"))
    @ElementCollection(targetClass = CustomFieldMultipleSelectEnum.class)
    @Column(name = "VALUE", nullable = false)
    private Set<CustomFieldMultipleSelectEnum> customFieldMultipleSelect = new HashSet<>();
    @JoinTable(name = "MyEntity3600_MyEntity3600Pick",
            joinColumns = @JoinColumn(name = "MyEntity3600_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3600Pick_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3600Multi2> customFieldMultivalueList = new ArrayList<>();
    @Column
    private String customFieldHint;
    @JoinTable(name = "MyEntity3600_MyEntity3600Multi",
            joinColumns = @JoinColumn(name = "MyEntity3600_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3600Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3600Multi> customFieldMultivalueHoverList = new ArrayList<>();
    @Column
    private LocalDateTime customFieldDate;
}