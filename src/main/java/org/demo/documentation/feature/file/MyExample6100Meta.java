package org.demo.documentation.feature.file;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.feature.file.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyExample6100Meta extends FieldMetaBuilder<MyExample6100DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample6100DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
      fields.setEnumValues(MyExample6100DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
      fields.setEnabled(MyExample6100DTO_.customFieldDictionary);
      fields.setEnabled(MyExample6100DTO_.customFieldFileId);
      fields.setEnabled(MyExample6100DTO_.customFieldFile);
      fields.setEnabled(MyExample6100DTO_.customField);

    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample6100DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.setEnumFilterValues(fields, MyExample6100DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
      fields.enableFilter(MyExample6100DTO_.customFieldDictionary);
      fields.enableFilter(MyExample6100DTO_.customFieldFile);
      fields.setFileAccept(MyExample6100DTO_.customFieldFile, List.of(".png",".pdf",".jpg",".jpeg"));

    }

}