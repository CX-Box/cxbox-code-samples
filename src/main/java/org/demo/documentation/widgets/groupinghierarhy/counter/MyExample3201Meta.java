package org.demo.documentation.widgets.groupinghierarhy.counter;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.counter.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3201Meta extends FieldMetaBuilder<MyExample3201DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3201DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
      fields.setEnabled(MyExample3201DTO_.customFieldDictionary);
      fields.setEnabled(MyExample3201DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3201DTO> fields, InnerBcDescription bcDescription, Long parentId) {
      fields.setEnumValues(MyExample3201DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
      fields.setEnumFilterValues(fields, MyExample3201DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
      fields.enableFilter(MyExample3201DTO_.customFieldDictionary);
      fields.defaultGroupingHierarchy(
              MyExample3201DTO_.customFieldDictionary,
              lvl -> lvl
                      .add(CustomFieldDictionaryEnum.UPPER_MIDDLE)
      );
    }

}