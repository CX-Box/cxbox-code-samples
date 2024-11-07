package org.demo.documentation.fields.dictionary.dictionarylov;

import static org.cxbox.api.data.dto.rowmeta.IconCode.ARROW_UP_RED;
import static org.demo.documentation.fields.dictionary.dictionarylov.AdministeredDictionaryType.REGIONS;
import static org.demo.documentation.fields.dictionary.dictionarylov.IconsEnum.*;

import org.cxbox.api.data.dictionary.LOV;
import org.cxbox.api.data.dto.rowmeta.Icon;
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

    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample350DTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

        fields.enableFilter(MyExample350DTO_.customField);
        fields.enableSort(MyExample350DTO_.customField);
        Map<LOV, Icon> valueIconMap = Map.of(
                REGIONS.lookupName("MOSCOW"), ARROW_UP,
                REGIONS.lookupName("SAINT PETERBURG"), ARROW_UP,
                REGIONS.lookupName("SYKTYVKAR"), ARROW_DOWN,
                REGIONS.lookupName("KOSTROMA"), ARROW_MIDDLE);
        fields.setAllValuesWithIcons(MyExample350DTO_.customField, REGIONS, valueIconMap);
    }
    // --8<-- [end:buildIndependentMeta]
}