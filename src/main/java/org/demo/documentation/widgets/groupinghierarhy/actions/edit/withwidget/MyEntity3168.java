package org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.CustomFieldDictionary2Enum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.CustomFieldDictionary3Enum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.DocTypeEnum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.FileTypeCdEnum;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3168 extends BaseEntity {
    @Column
    private String customField;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionary2Enum customFieldDictionary2;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionary3Enum customFieldDictionary3;
    @Enumerated(value = EnumType.STRING)
    @Column
    private DocTypeEnum docType;
    @Enumerated(value = EnumType.STRING)
    @Column
    private FileTypeCdEnum fileTypeCd;
    @Column
    private String fileName;
    @Column
    private String fileNameId;
    @Column
    private LocalDateTime dateReceipt;
    @Column
    private Boolean needAnAnswer;
    @Column
    private String fileId;
    @Column
    private String sodfuDocNumber;
}