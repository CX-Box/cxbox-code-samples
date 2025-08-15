package org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget;

import org.apache.commons.lang3.BooleanUtils;
import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.cxbox.dictionary.DictionaryProvider;
import org.demo.documentation.other.forceactive2.MyExample4901DTO_;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.CustomFieldDictionary2Enum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.CustomFieldDictionary3Enum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.DocTypeEnum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.FileTypeCdEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3168Meta extends FieldMetaBuilder<MyExample3168DTO> {

    private final DictionaryProvider dictionaryProvider;

    public MyExample3168Meta(DictionaryProvider dictionaryProvider) {
        this.dictionaryProvider = dictionaryProvider;
    }

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3168DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3168DTO_.fileId);
        fields.setEnabled(MyExample3168DTO_.dateReceipt);
        fields.setEnabled(MyExample3168DTO_.createdDate);
        fields.setEnabled(MyExample3168DTO_.fileNameId);
        fields.setEnabled(MyExample3168DTO_.fileName);
        fields.setEnumValues(MyExample3168DTO_.fileTypeCd, FileTypeCdEnum.values());
        fields.setEnabled(MyExample3168DTO_.fileTypeCd);
        fields.setEnumValues(MyExample3168DTO_.docType, DocTypeEnum.values());
        fields.setEnabled(MyExample3168DTO_.docType);
        if (fields.isFieldChangedNow(fields, MyExample3168DTO_.customFieldDictionary3)) {
            fields.setCurrentValue(MyExample3168DTO_.customFieldDictionary2, null);
            fields.setCurrentValue(MyExample3168DTO_.customField, null);
        }
        fields.setEnumValues(MyExample3168DTO_.customFieldDictionary3, CustomFieldDictionary3Enum.values());
        fields.setEnabled(MyExample3168DTO_.customFieldDictionary3);
        fields.setEnumValues(MyExample3168DTO_.customFieldDictionary2, CustomFieldDictionary2Enum.values());
        fields.setEnabled(MyExample3168DTO_.customFieldDictionary2);
        fields.setEnabled(MyExample3168DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3168DTO_.customField);
        fields.setRequired(MyExample3168DTO_.customFieldDictionary2);
        fields.setEnumValues(MyExample3168DTO_.docType, DocTypeEnum.values());


        if (fields.isFieldChangedNow(fields, MyExample3168DTO_.docType)) {
            fields.setCurrentValue(MyExample3168DTO_.fileTypeCd, null);
            fields.setCurrentValue(MyExample3168DTO_.dateReceipt, null);
            fields.setCurrentValue(MyExample3168DTO_.needAnAnswer, false);
            fields.setCurrentValue(MyExample3168DTO_.sodfuDocNumber, null);
        }
        if (fields.isFieldChangedNow(fields, MyExample3168DTO_.needAnAnswer)
                && fields.getCurrentValue(MyExample3168DTO_.needAnAnswer).filter(BooleanUtils::isTrue).isPresent()) {
            fields.setRequired(MyExample3168DTO_.sodfuDocNumber);
        }

    if (!(Objects.equals(fields.getCurrentValue(MyExample3168DTO_.docType).orElse(null), DocTypeEnum.HIGH))) {

            fields.setEnabled(
                    MyExample3168DTO_.sodfuDocNumber,
                    MyExample3168DTO_.needAnAnswer
            );
        }

        fields.setRequired(
                MyExample3168DTO_.docType,
                MyExample3168DTO_.fileTypeCd,
                MyExample3168DTO_.fileName
        );


    }
    // --8<-- [end:buildRowDependentMeta]

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3168DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3168DTO_.sodfuDocNumber);
        fields.enableFilter(MyExample3168DTO_.fileId);
        fields.enableFilter(MyExample3168DTO_.needAnAnswer);
        fields.enableFilter(MyExample3168DTO_.dateReceipt);
        fields.enableFilter(MyExample3168DTO_.createdDate);
        fields.enableFilter(MyExample3168DTO_.fileName);
        fields.setEnumFilterValues(fields, MyExample3168DTO_.fileTypeCd, FileTypeCdEnum.values());
        fields.enableFilter(MyExample3168DTO_.fileTypeCd);
        fields.setEnumFilterValues(fields, MyExample3168DTO_.docType, DocTypeEnum.values());
        fields.enableFilter(MyExample3168DTO_.docType);
        fields.setEnumFilterValues(fields, MyExample3168DTO_.customFieldDictionary3, CustomFieldDictionary3Enum.values());
        fields.enableFilter(MyExample3168DTO_.customFieldDictionary3);
        fields.setEnumFilterValues(fields, MyExample3168DTO_.customFieldDictionary2, CustomFieldDictionary2Enum.values());
        fields.enableFilter(MyExample3168DTO_.customFieldDictionary2);
        fields.setEnumValues(MyExample3168DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnumFilterValues(fields, MyExample3168DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.enableFilter(MyExample3168DTO_.customFieldDictionary);
        fields.setForceActive(MyExample3168DTO_.customFieldDictionary3);

        fields.enableFilter(
                MyExample3168DTO_.docType,
                MyExample3168DTO_.fileTypeCd,
                MyExample3168DTO_.fileName,
                MyExample3168DTO_.createdDate
        );
        fields.enableSort(
                MyExample3168DTO_.docType,
                MyExample3168DTO_.fileTypeCd,
                MyExample3168DTO_.fileName,
                MyExample3168DTO_.createdDate
        );


        fields.setForceActive(MyExample3168DTO_.docType);
        fields.setForceActive(MyExample3168DTO_.needAnAnswer);


    }

}