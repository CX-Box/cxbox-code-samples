package org.demo.documentation.other.widgetEditStyles.colortitle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.widgetEditStyles.colortitle.enums.WidgetStylesColorDictionaryEnum;
import org.demo.documentation.other.widgetEditStyles.colortitle.enums.WidgetStylesColorRadioEnum;
import org.demo.documentation.other.widgetEditStyles.colortitle.enums.WidgetStylesTestEnum;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesInlinePicklist;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesMulti;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesMultiMulti;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesPicklist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class WidgetStyles extends BaseEntity {
    @Column
    private String customField;
    @JoinTable(name = "WidgetStyles_WidgetStylesMulti",
            joinColumns = @JoinColumn(name = "WidgetStyles_id"),
            inverseJoinColumns = @JoinColumn(name = "WidgetStylesMulti_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<WidgetStylesMulti> customFieldColorMultivalueHoverList = new ArrayList<>();
    @JoinTable(name = "WidgetStyles_WidgetStylesMultiMulti",
            joinColumns = @JoinColumn(name = "WidgetStyles_id"),
            inverseJoinColumns = @JoinColumn(name = "WidgetStylesMultiMulti_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<WidgetStylesMultiMulti> customFieldColorMultivalueList = new ArrayList<>();
    @JoinColumn(name = "CUSTOM_FIELD_COLOR_INLINE_PICKLIST_ID")
    @ManyToOne
    private WidgetStylesInlinePicklist customFieldColorInlinePicklistEntity;
    @JoinColumn(name = "CUSTOM_FIELD_COLOR_PICKLIST_ID")
    @ManyToOne
    private WidgetStylesPicklist customFieldColorPicklistEntity;
    @Enumerated(value = EnumType.STRING)
    @Column
    private WidgetStylesColorRadioEnum customFieldColorRadio;
    @Column
    private Double customFieldColorMoney;
    @Column
    private String suggestion;
    @Column
    private String suggestionDate;
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
    private WidgetStylesColorDictionaryEnum customFieldColorDictionary;
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
    private String customFieldSuggestion;
    @Column
    private LocalDateTime customFieldSuggestionDate;
    @Column
    private String customFieldColorInput;
    @Enumerated(value = EnumType.STRING)
    @CollectionTable(name = "multipleSelect", joinColumns = @JoinColumn(name = "WidgetStyles_ID"))
    @ElementCollection(targetClass = WidgetStylesTestEnum.class)
    @Column(name = "VALUE", nullable = false)
    private Set<WidgetStylesTestEnum> multipleSelect = new HashSet<>();
    @Column
    private String hint;
    @Column
    private LocalDateTime time;
    @Column
    private String hidden;
}