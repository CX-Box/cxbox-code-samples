package org.demo.documentation.fields.percent.sorting;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.fields.date.sorting.DateSortingDTO_;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample9Meta extends FieldMetaBuilder<MyExample9DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample9DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample9DTO_.customField
		);
		fields.setRequired(
				MyExample9DTO_.customField
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample9DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableSort(MyExample9DTO_.customField);
		//
	}


}