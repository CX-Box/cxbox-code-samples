package org.demo.documentation.widgets.tree.title;

import lombok.AllArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyExample3271Meta extends FieldMetaBuilder<MyExample3271DTO> {

	// --8<-- [start:buildRowDependentMeta]
	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3271DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setDisabled(MyExample3271DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3271DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3271DTO_.customField);
		fields.enableSort(MyExample3271DTO_.customField);
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample3271DTO_.customField);
		}
	}
	// --8<-- [end:buildIndependentMeta]
}