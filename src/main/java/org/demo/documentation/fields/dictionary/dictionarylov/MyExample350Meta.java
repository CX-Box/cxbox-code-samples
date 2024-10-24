package org.demo.documentation.fields.dictionary.dictionarylov;

import static org.cxbox.api.data.dto.rowmeta.IconCode.*;
import static org.demo.documentation.fields.dictionary.dictionarylov.AdministeredDictionaryType.REGIONS;
import static org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum.*;

import org.cxbox.api.data.dictionary.LOV;
import org.cxbox.api.data.dto.rowmeta.IconCode;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;
import java.util.Map;


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
        Map<LOV, IconCode> valueIconMap = Map.of(
                REGIONS.lookupName("MOSCOW"), ARROW_UP_RED,
                REGIONS.lookupName("SAINT PETERBURG"), ARROW_UP_ORANGE,
                REGIONS.lookupName("SYKTYVKAR"), ARROW_UP_ORANGE,
                REGIONS.lookupName("KOSTROMA"), ARROW_DOWN_GREEN);
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

        Map<LOV, IconCode> valueIconMap = Map.of(
                REGIONS.lookupName("MOSCOW"), ARROW_UP_RED,
                REGIONS.lookupName("SAINT PETERBURG"), ARROW_UP_ORANGE,
                REGIONS.lookupName("SYKTYVKAR"), ARROW_UP_ORANGE,
                REGIONS.lookupName("KOSTROMA"), ARROW_DOWN_GREEN);
        fields.setFilterValuesWithIcons(MyExample350DTO_.customField, REGIONS,valueIconMap);
    }
    // --8<-- [end:buildIndependentMeta]
}