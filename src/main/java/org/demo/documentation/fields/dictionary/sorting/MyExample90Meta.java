package org.demo.documentation.fields.dictionary.sorting;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.fields.date.sorting.DateSortingDTO_;
import org.demo.documentation.fields.dictionary.sorting.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample90Meta extends FieldMetaBuilder<MyExample90DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample90DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample90DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample90DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample90DTO_.customField);
		}
		fields.setEnumValues(MyExample90DTO_.customField, CustomFieldEnum.values());
		fields.setEnumFilterValues(fields, MyExample90DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample90DTO_.customField);
		fields.enableSort(MyExample90DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}