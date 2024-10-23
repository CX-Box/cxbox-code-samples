package org.demo.documentation.fields.dictionary.dictionarylov;

import static org.cxbox.api.data.dto.rowmeta.IconCode.ARROW_UP_ORANGE;
import static org.cxbox.api.data.dto.rowmeta.IconCode.ARROW_UP_RED;
import static org.demo.documentation.fields.dictionary.dictionarylov.AdministeredDictionaryType.REGIONS;

import org.cxbox.api.data.dictionary.LOV;
import org.cxbox.api.data.dto.rowmeta.IconCode;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.dictionary.icon.MyExample3011DTO_;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MyExample350Meta extends FieldMetaBuilder<MyExample350DTO> {

    private final MyEntity350Repository repository;

    public MyExample350Meta(MyEntity350Repository repository) {
        this.repository = repository;
    }

    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample350DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample350DTO_.customField);
        fields.setDictionaryTypeWithAllValues(MyExample350DTO_.customField, REGIONS);
        Map<LOV, IconCode> valueIconMap = new HashMap<>();
        valueIconMap.put(REGIONS.lookupName("MOSCOW"), ARROW_UP_RED);
        valueIconMap.put(REGIONS.lookupName("SAINT PETERBURG"), ARROW_UP_ORANGE);
        valueIconMap.put(REGIONS.lookupName("KOSTROMA"), ARROW_UP_ORANGE);
        valueIconMap.put(REGIONS.lookupName("SYKTYVKAR"), ARROW_UP_RED);

        fields.setDictionaryValuesWithIcons(MyExample350DTO_.customField, REGIONS,valueIconMap);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample350DTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {
        fields.setDictionaryTypeWithAllValues(MyExample350DTO_.customField, REGIONS);
        fields.setAllFilterValuesByLovType(MyExample350DTO_.customField, REGIONS);
        fields.enableFilter(MyExample350DTO_.customField);
        fields.enableSort(MyExample350DTO_.customField);
        fields.setFilterValuesWithIcons();
        Map<LOV, IconCode> valueIconMap = new HashMap<>();
        valueIconMap.put(REGIONS.lookupName("MOSCOW"), ARROW_UP_RED);
        valueIconMap.put(REGIONS.lookupName("SAINT PETERBURG"), ARROW_UP_ORANGE);
        valueIconMap.put(REGIONS.lookupName("KOSTROMA"), ARROW_UP_ORANGE);
        valueIconMap.put(REGIONS.lookupName("SYKTYVKAR"), ARROW_UP_RED);
        Optional.ofNullable(MyExample3011DTO_.customFieldDictionary).map(dtoField -> fields.get(dtoField.getName()))
                .ifPresent(fieldDTO -> {
                    fieldDTO.setDictionaryName(fieldDTO.getDictionaryName());
                    fieldDTO.clearFilterValues();
                    valueIconMap
                            .forEach((key, value) -> fieldDTO
                                    .setIconWithValue(key.getKey(), value, true));
                });
    }
    // --8<-- [end:buildIndependentMeta]
}