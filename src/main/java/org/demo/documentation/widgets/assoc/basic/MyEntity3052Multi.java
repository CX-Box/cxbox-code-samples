package org.demo.documentation.widgets.assoc.basic;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.assoc.basic.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.assoc.basic.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.assoc.basic.forfields.MyEntity3052MultiAssoc;
import org.demo.documentation.widgets.assoc.basic.forfields.MyEntity3052MultiMultiAssoc;
import org.demo.documentation.widgets.assoc.basic.forfields.MyEntity3052Picklist;
import org.demo.documentation.widgets.assoc.basic.forfields.MyEntity3052PicklistAssoc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3052Multi extends BaseEntity {
    @Column
    private String customField;
    @JoinTable(name = "MyEntity3052Multi_MyEntity3052MultiAssoc",
            joinColumns = @JoinColumn(name = "MyEntity3052Multi_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3052MultiAssoc_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3052MultiAssoc> customFieldColorMultivalueHoverList = new ArrayList<>();
    @JoinTable(name = "MyEntity3052Multi_MyEntity3052MultiMultiAssoc",
            joinColumns = @JoinColumn(name = "MyEntity3052Multi_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3052MultiMultiAssoc_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3052MultiMultiAssoc> customFieldColorMultivalueList = new ArrayList<>();
    @JoinColumn(name = "CUSTOM_FIELD_COLOR_INLINE_PICKLIST_ID")
    @ManyToOne
    private MyEntity3052Picklist customFieldColorInlinePicklistEntity;
    @JoinColumn(name = "CUSTOM_FIELD_COLOR_PICKLIST_ID")
    @ManyToOne
    private MyEntity3052PicklistAssoc customFieldColorPicklistEntity;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldColorRadioEnum customFieldColorRadio;
    @Column
    private Double customFieldColorMoney;
    @Column
    private Long customFieldColorPercent;
    @Column
    private Long customFieldColorNumber;
    @Column
    private String customFieldColorFileUploade;
    @Column
    private String customFieldColorFileUploadeId;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldColorDictionaryEnum customFieldColorDictionary;
    @Column
    private LocalDateTime customFieldColorDateTimeWithSeconds;
    @Column
    private LocalDateTime customFieldColorDate;
    @Column
    private Boolean customFieldColorCheckbox;
    @Column
    private LocalDateTime customFieldColorDateTime;
    @Column
    private String customFieldColorText;
    @Column
    private String customFieldColorInput;
}