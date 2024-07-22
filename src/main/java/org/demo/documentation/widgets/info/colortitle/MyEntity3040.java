package org.demo.documentation.widgets.info.colortitle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.info.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.info.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040InlinePicklist;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040Multi;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040MultiMulti;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040Picklist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3040 extends BaseEntity {
    @Column
    private String customField;
    @JoinTable(name = "MyEntity3040_MyEntity3040Multi",
            joinColumns = @JoinColumn(name = "MyEntity3040_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3040Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3040Multi> customFieldColorMultivalueHoverList = new ArrayList<>();
    @JoinTable(name = "MyEntity3040_MyEntity3040MultiMulti",
            joinColumns = @JoinColumn(name = "MyEntity3040_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3040MultiMulti_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3040MultiMulti> customFieldColorMultivalueList = new ArrayList<>();
    @JoinColumn(name = "CUSTOM_FIELD_COLOR_INLINE_PICKLIST_ID")
    @ManyToOne
    private MyEntity3040InlinePicklist customFieldColorInlinePicklistEntity;
    @JoinColumn(name = "CUSTOM_FIELD_COLOR_PICKLIST_ID")
    @ManyToOne
    private MyEntity3040Picklist customFieldColorPicklistEntity;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldColorRadioEnum customFieldColorRadio;
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