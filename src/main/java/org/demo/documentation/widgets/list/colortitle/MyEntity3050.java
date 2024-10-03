package org.demo.documentation.widgets.list.colortitle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.list.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.list.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050InlinePicklist;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050Multi;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050MultiMulti;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050Picklist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3050 extends BaseEntity {
    @Column
    private String customFieldText;
    @Column
    private String customField;
    @JoinTable(name = "MyEntity3050_MyEntity3050Multi",
            joinColumns = @JoinColumn(name = "MyEntity3050_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3050Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3050Multi> customFieldColorMultivalueHoverList = new ArrayList<>();
    @JoinTable(name = "MyEntity3050_MyEntity3050MultiMulti",
            joinColumns = @JoinColumn(name = "MyEntity3050_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3050MultiMulti_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3050MultiMulti> customFieldColorMultivalueList = new ArrayList<>();
    @JoinColumn(name = "CUSTOM_FIELD_COLOR_INLINE_PICKLIST_ID")
    @ManyToOne
    private MyEntity3050InlinePicklist customFieldColorInlinePicklistEntity;
    @JoinColumn(name = "CUSTOM_FIELD_COLOR_PICKLIST_ID")
    @ManyToOne
    private MyEntity3050Picklist customFieldColorPicklistEntity;
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