package org.demo.documentation.widgets.form.colortitle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.form.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.form.colortitle.enums.CustomFieldColorRadioEnum;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3026 extends BaseEntity {
    @Column
    private String customField;
    @JoinColumn(name = "CUSTOM_FIELD_COLOR_INLINE_PICKLIST_ID")
    @ManyToOne
    private MyEntity3031 customFieldColorInlinePicklistEntity;
    @JoinColumn(name = "CUSTOM_FIELD_COLOR_PICKLIST_ID")
    @ManyToOne
    private MyEntity3032 customFieldColorPicklistEntity;
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