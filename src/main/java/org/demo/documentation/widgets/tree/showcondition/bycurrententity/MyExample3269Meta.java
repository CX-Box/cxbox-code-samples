package org.demo.documentation.widgets.tree.showcondition.bycurrententity;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample3269Meta extends FieldMetaBuilder<MyExample3269DTO> {
	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3269DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3269DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3269DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3269DTO_.customField);
		fields.enableSort(MyExample3269DTO_.customField);
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample3269DTO_.customField);
		}
	}
	// --8<-- [end:buildIndependentMeta]
}