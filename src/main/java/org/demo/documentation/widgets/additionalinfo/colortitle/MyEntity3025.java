package org.demo.documentation.widgets.additionalinfo.colortitle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.additionalinfo.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.additionalinfo.colortitle.enums.CustomFieldColorRadioEnum;

import java.time.LocalDateTime;


// 3025
// 3025
// Widget additionalinfo color

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3025 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customFieldColorInput;
    @Column
    private String customFieldColorText;
    @Column
    private LocalDateTime customFieldColorDateTime;
    @Column
    private Boolean customFieldColorCheckbox;
    @Column
    private LocalDateTime customFieldColorDate;
    @Column
    private LocalDateTime customFieldColorDateTimeWithSeconds;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldColorDictionaryEnum customFieldColorDictionary;
    @Column
    private String customFieldColorFileUploade;
    @Column
    private String customFieldColorFileUploadeId;
    @Column
    private Long customFieldColorNumber;
    @Column
    private Long customFieldColorPercent;
    @Column
    private Double customFieldColorMoney;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldColorRadioEnum customFieldColorRadio;
    @JoinColumn(name = "CUSTOM_FIELD_COLOR_PICKLIST_ID")
    @ManyToOne
    private MyEntity3029 customFieldColorPicklistEntity;
    @JoinColumn(name = "CUSTOM_FIELD_COLOR_INLINE_PICKLIST_ID")
    @ManyToOne
    private MyEntity3030 customFieldColorInlinePicklistEntity;
}