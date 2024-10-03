package org.demo.documentation.widgets.formpopup.colortitle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.formpopup.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.formpopup.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3041;
import org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3042;
import org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3043;
import org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3044;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3027 extends BaseEntity {
    @Column
    private String customFieldText;

    @Column
    private String customField;
    @JoinTable(name = "MyEntity3027_MyEntity3041",
            joinColumns = @JoinColumn(name = "MyEntity3027_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3041_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3041> customFieldColorMultivalueHoverList = new ArrayList<>();
    @JoinTable(name = "MyEntity3027_MyEntity3042",
            joinColumns = @JoinColumn(name = "MyEntity3027_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3042_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3042> customFieldColorMultivalueList = new ArrayList<>();
    @JoinColumn(name = "CUSTOM_FIELD_COLOR_INLINE_PICKLIST_ID")
    @ManyToOne
    private MyEntity3043 customFieldColorInlinePicklistEntity;
    @JoinColumn(name = "CUSTOM_FIELD_COLOR_PICKLIST_ID")
    @ManyToOne
    private MyEntity3044 customFieldColorPicklistEntity;
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