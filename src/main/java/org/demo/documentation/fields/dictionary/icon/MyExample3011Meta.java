package org.demo.documentation.fields.dictionary.icon;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.cxbox.api.data.dictionary.LOV;
import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.api.data.dto.rowmeta.FieldDTO;
import org.cxbox.api.data.dto.rowmeta.IconCode;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.dictionary.dictionarylov.MyEntity350;
import org.demo.documentation.fields.dictionary.dictionarylov.MyEntity350Repository;
import org.demo.documentation.fields.dictionary.dictionarylov.MyExample350DTO_;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static org.cxbox.api.data.dto.rowmeta.IconCode.*;
import static org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum.*;

@Service
public class MyExample3011Meta extends FieldMetaBuilder<MyExample3011DTO> {

    private final MyEntity3011Repository repository;
    private final ObjectMapper objectMapper;

    public MyExample3011Meta(MyEntity3011Repository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3011DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnumValues(MyExample3011DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
        fields.setEnabled(MyExample3011DTO_.customFieldDictionary);
        fields.setEnabled(MyExample3011DTO_.customField);
        Map<String, IconCode> valueIconMap = new HashMap<>();
        valueIconMap.put(HIGH.getValue(), ARROW_UP_RED);
        valueIconMap.put(MIDDLE.getValue(), ARROW_UP_ORANGE);
        valueIconMap.put(LOW.getValue(), ARROW_DOWN_GREEN);
        Optional.ofNullable(MyExample3011DTO_.customFieldDictionary).map(dtoField -> fields.get(dtoField.getName()))
                .ifPresent(fieldDTO -> {
                    fieldDTO.setDictionaryName(fieldDTO.getDictionaryName());
                    fieldDTO.clearValues();
                    valueIconMap
                            .forEach((key, value) -> fieldDTO
                                    .setIconWithValue(key, value, false));
                });

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3011DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableSort(MyExample3011DTO_.customFieldDictionary);
        fields.enableFilter(MyExample3011DTO_.customFieldDictionary);
        Map<String, IconCode> valueIconMap = Map.of(HIGH.getValue(), ARROW_UP_RED,
                MIDDLE.getValue(), ARROW_UP_ORANGE,
                LOW.getValue(), ARROW_DOWN_GREEN);
        Optional.ofNullable(MyExample3011DTO_.customFieldDictionary).map(dtoField -> fields.get(dtoField.getName()))
                .ifPresent(fieldDTO -> {
                    fieldDTO.setDictionaryName(fieldDTO.getDictionaryName());
                    fieldDTO.clearFilterValues();
                    valueIconMap
                            .forEach((key, value) -> fieldDTO
                                    .setIconWithValue(key, value, true));
                });
    }


}
