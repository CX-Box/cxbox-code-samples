package org.demo.documentation.fields.picktree.validationruntimeex;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample3295Meta extends FieldMetaBuilder<MyExample3295DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3295DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3295DTO_.customFieldId);
		fields.setEnabled(MyExample3295DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3295DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample3295DTO_.customField);
		}
		fields.enableFilter(MyExample3295DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}