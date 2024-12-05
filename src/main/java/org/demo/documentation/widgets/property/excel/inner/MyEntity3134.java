package org.demo.documentation.widgets.property.excel.inner;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.property.excel.inner.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.property.excel.inner.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.property.excel.inner.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134InlinePick;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134Multi;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134MultiHover;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134Pick;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3134 extends BaseEntity {
    @Column
    private String customField;
    @JoinTable(name = "MyEntity3134_MyEntity3134MultiHover",
            joinColumns = @JoinColumn(name = "MyEntity3134_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3134MultiHover_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3134MultiHover> customFieldMultivalueHoverList = new ArrayList<>();
    @Column
    private String customFieldHint;
    @JoinTable(name = "MyEntity3134_MyEntity3134Multi",
            joinColumns = @JoinColumn(name = "MyEntity3134_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3134Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3134Multi> customFieldMultivalueList = new ArrayList<>();
    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT_3134", joinColumns = @JoinColumn(name = "MyEntity3134_ID"))
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
    private MyEntity3134InlinePick customFieldInlineEntity;
    @JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
    @ManyToOne
    private MyEntity3134Pick customFieldPickListEntity;
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