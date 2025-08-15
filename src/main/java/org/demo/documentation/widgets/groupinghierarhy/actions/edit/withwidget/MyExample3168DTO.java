package org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;

import org.demo.documentation.widgets.groupinghierarhy.actions.edit.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.CustomFieldDictionary2Enum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.CustomFieldDictionary3Enum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.DocTypeEnum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.FileTypeCdEnum;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3168DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;
    @SearchParameter(name = "customFieldDictionary2", provider = EnumValueProvider.class)
    private CustomFieldDictionary2Enum customFieldDictionary2;
    @SearchParameter(name = "customFieldDictionary3", provider = EnumValueProvider.class)
    private CustomFieldDictionary3Enum customFieldDictionary3;
    @SearchParameter(name = "docType", provider = EnumValueProvider.class)
    private DocTypeEnum docType;
    @SearchParameter(name = "fileTypeCd", provider = EnumValueProvider.class)
    private FileTypeCdEnum fileTypeCd;
    @SearchParameter(name = "fileName", provider = StringValueProvider.class)
    private String fileName;
    private String fileNameId;
    @SearchParameter(name = "createdDate", provider = DateTimeValueProvider.class)
    private LocalDateTime createdDate;
    @SearchParameter(name = "dateReceipt", provider = DateValueProvider.class)
    private LocalDateTime dateReceipt;
    @SearchParameter(name = "needAnAnswer", provider = BooleanValueProvider.class)
    private Boolean needAnAnswer;
    @SearchParameter(name = "fileId", provider = StringValueProvider.class)
    private String fileId;
    @SearchParameter(name = "sodfuDocNumber", provider = StringValueProvider.class)
    private String sodfuDocNumber;

    public MyExample3168DTO(MyEntity3168 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldDictionary2 = entity.getCustomFieldDictionary2();
        this.customFieldDictionary3 = entity.getCustomFieldDictionary3();
        this.docType = entity.getDocType();
        this.fileTypeCd = entity.getFileTypeCd();
        this.fileName = entity.getFileName();
        this.fileNameId = entity.getFileNameId();
        this.createdDate = entity.getCreatedDate();
        this.dateReceipt = entity.getDateReceipt();
        this.needAnAnswer = entity.getNeedAnAnswer();
        this.fileId = entity.getFileId();
        this.sodfuDocNumber = entity.getSodfuDocNumber();
    }
}