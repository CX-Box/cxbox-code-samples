package org.demo.documentation.other.alltypes;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.other.alltypes.enums.DictionaryTypeEnum;
import org.demo.documentation.other.alltypes.enums.MultipleTypeEnum;
import org.demo.documentation.other.alltypes.enums.RadioTypeEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class MyExample421Meta extends FieldMetaBuilder<MyExample421DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample421DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample421DTO_.multihoverType);
        fields.setEnabled(MyExample421DTO_.hintType);
        fields.setEnabled(MyExample421DTO_.multivalueType);
        fields.setDictionaryTypeWithCustomValues(MyExample421DTO_.multipleType, Arrays.stream(MultipleTypeEnum.values())
                .map(MultipleTypeEnum::getValue)
                .toArray(String[]::new));
        fields.setEnabled(MyExample421DTO_.multipleType);
        fields.setEnabled(MyExample421DTO_.inlinepicklistTypeId);
        fields.setEnabled(MyExample421DTO_.inlinepicklistType);
        fields.setEnabled(MyExample421DTO_.picklistTypeId);
        fields.setEnabled(MyExample421DTO_.picklistType);

        fields.setEnumValues(MyExample421DTO_.radioType, RadioTypeEnum.values());
        fields.setEnabled(MyExample421DTO_.radioType);
        fields.setEnabled(MyExample421DTO_.moneyType);
        fields.setEnabled(MyExample421DTO_.percentTypeDouble);
        fields.setEnabled(MyExample421DTO_.percentType);
        fields.setEnabled(MyExample421DTO_.numberTypeDouble);

        fields.setEnabled(MyExample421DTO_.numberType);
        fields.setEnabled(MyExample421DTO_.fileUploadTypeId);
        fields.setEnabled(MyExample421DTO_.fileUploadType);
        fields.setEnumValues(MyExample421DTO_.dictionaryType, DictionaryTypeEnum.values());
        fields.setEnabled(MyExample421DTO_.dictionaryType);
        fields.setEnabled(MyExample421DTO_.dateTimeWithSecondsType);
        fields.setEnabled(MyExample421DTO_.dateType);
        fields.setEnabled(MyExample421DTO_.checkboxType);
        fields.setEnabled(MyExample421DTO_.dateTimeType);
        fields.setEnabled(MyExample421DTO_.textType);
        fields.setEnabled(MyExample421DTO_.hiddenType);
        fields.setEnabled(MyExample421DTO_.inputField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample421DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample421DTO_.multihoverType);
        fields.enableFilter(MyExample421DTO_.hintType);
        fields.enableFilter(MyExample421DTO_.multivalueType);
        fields.setConcreteFilterValues(MyExample421DTO_.multipleType, Arrays.stream(MultipleTypeEnum.values())
                .map(en -> new SimpleDictionary(en.name(), en.getValue()))
                .collect(Collectors.toList()));
        fields.enableFilter(MyExample421DTO_.multipleType);
        fields.enableFilter(MyExample421DTO_.inlinepicklistType);
        fields.enableFilter(MyExample421DTO_.picklistType);

        fields.setEnumFilterValues(fields, MyExample421DTO_.radioType, RadioTypeEnum.values());
        fields.enableFilter(MyExample421DTO_.radioType);
        fields.enableFilter(MyExample421DTO_.moneyType);
        fields.enableFilter(MyExample421DTO_.percentTypeDouble);
        fields.enableFilter(MyExample421DTO_.percentType);
        fields.enableFilter(MyExample421DTO_.numberTypeDouble);

        fields.enableFilter(MyExample421DTO_.numberType);
        fields.enableFilter(MyExample421DTO_.fileUploadType);
        fields.setEnumFilterValues(fields, MyExample421DTO_.dictionaryType, DictionaryTypeEnum.values());
        fields.enableFilter(MyExample421DTO_.dictionaryType);
        fields.enableFilter(MyExample421DTO_.dateTimeWithSecondsType);
        fields.enableFilter(MyExample421DTO_.dateType);
        fields.enableFilter(MyExample421DTO_.checkboxType);
        fields.enableFilter(MyExample421DTO_.dateTimeType);
        fields.enableFilter(MyExample421DTO_.textType);
        fields.enableFilter(MyExample421DTO_.hiddenType);
        fields.enableFilter(MyExample421DTO_.inputField);
    }

}