package org.demo.documentation.widgets.info.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import org.demo.documentation.widgets.info.base.forfields.MyEntity4222Multi;
import org.demo.documentation.widgets.info.base.forfields.MyEntity4222Multi2;
import org.demo.documentation.widgets.info.base.forfields.MyEntity4222Pick;
import org.demo.documentation.widgets.info.base.forfields.MyEntity4222Pick2;
import org.demo.documentation.widgets.info.base.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.info.base.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.info.base.enums.CustomFieldRadioEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3001 extends BaseEntity {

    @Column
    private String customField;

    @Column
    private LocalDateTime customFieldDate;
    @Column
    private String customFieldHint;
    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT2", joinColumns = @JoinColumn(name = "MyEntity3001_ID"))
    @ElementCollection(targetClass = CustomFieldMultipleSelectEnum.class)
    @Column(name = "VALUE", nullable = false)
    private Set<CustomFieldMultipleSelectEnum> customFieldMultipleSelect = new HashSet<>();
    @Column
    private Long customFieldPercent;
    @Column
    private LocalDateTime customFieldDateTimeWithSeconds;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldRadioEnum customFieldRadio;
    @Column
    private Double customFieldMoney;
    @Column
    private Long customFieldNum;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;
    @Column
    private Boolean customFieldCheckbox;
    @Column
    private LocalDateTime customFieldDateTime;
    @Column
    private String customFieldText;
    @JoinTable(name = "MyEntity3001_MyEntity4222Multi",
            joinColumns = @JoinColumn(name = "MyEntity3001_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity4222Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity4222Multi> customFieldMultivalueHoverList = new ArrayList<>();
    @JoinTable(name = "MyEntity3001_MyEntity4222Multi2",
            joinColumns = @JoinColumn(name = "MyEntity3001_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity4222Multi2_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity4222Multi2> customFieldMultivalueList = new ArrayList<>();
    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
    @ManyToOne
    private MyEntity4222Pick customFieldPickListEntity;
    @JoinColumn(name = "CUSTOM_FIELD_INLINE_PICK_LIST_ID")
    @ManyToOne
    private MyEntity4222Pick2 customFieldInlinePickListEntity;
}