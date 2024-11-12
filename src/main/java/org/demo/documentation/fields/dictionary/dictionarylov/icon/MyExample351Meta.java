package org.demo.documentation.fields.dictionary.dictionarylov.icon;

import org.cxbox.api.data.dictionary.LOV;
import org.cxbox.api.data.dto.rowmeta.Icon;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.dictionary.dictionarylov.basic.MyExample350DTO_;
import org.springframework.stereotype.Service;

import java.util.Map;

import static org.demo.documentation.fields.dictionary.dictionarylov.AdministeredDictionaryType.REGIONS;
import static org.demo.documentation.fields.dictionary.dictionarylov.AdministeredDictionaryType.Regions.*;
import static org.demo.documentation.fields.dictionary.dictionarylov.icon.enums.IconsEnum.ARROW_UP;
import static org.demo.documentation.fields.dictionary.dictionarylov.icon.enums.IconsEnum.DOWN;
import static org.demo.documentation.fields.dictionary.icon.enums.IconsEnum.ARROW_UP_BLUE;
import static org.demo.documentation.fields.dictionary.icon.enums.IconsEnum.WATERMELON;

@Service
public class MyExample351Meta extends FieldMetaBuilder<MyExample351DTO> {
    // --8<-- [start:buildRowDependentMeta]
    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample351DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample351DTO_.customFieldDictionary);
        fields.setEnabled(MyExample351DTO_.customField);
    }
    // --8<-- [end:buildRowDependentMeta]

    // --8<-- [start:buildIndependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample351DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample351DTO_.customFieldDictionary);
        fields.enableSort(MyExample351DTO_.customFieldDictionary);
        fields.setDictionaryTypeWithAllValues(MyExample351DTO_.customFieldDictionary, REGIONS);
        Map<LOV, Icon> valueIconMap = Map.of(
                MOSCOW, ARROW_UP,
                SAINT_PETERBURG, DOWN,
                SYKTYVKAR, ARROW_UP_BLUE,
                KOSTROMA, WATERMELON);
        fields.setAllValuesWithIcons(MyExample351DTO_.customFieldDictionary, REGIONS, valueIconMap);
        fields.setAllFilterValuesByLovType(MyExample351DTO_.customFieldDictionary, REGIONS);
    }
    // --8<-- [end:buildIndependentMeta]
}