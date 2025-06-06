package org.demo.documentation.widgets.groupinghierarhy.colortitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.colortitle.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3133Meta extends FieldMetaBuilder<MyExample3133DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3133DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
      fields.setEnumValues(MyExample3133DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
      fields.setEnabled(MyExample3133DTO_.customFieldDictionary);
      fields.setEnabled(MyExample3133DTO_.customField);
    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3133DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.setEnumFilterValues(fields, MyExample3133DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
      fields.enableFilter(MyExample3133DTO_.customFieldDictionary);
      fields.enableSort(MyExample3133DTO_.customFieldDictionary);
      fields.enableSort(MyExample3133DTO_.customField);
    }

}