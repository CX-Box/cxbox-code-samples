package org.demo.documentation.fields.picktree.required;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample3288Meta extends FieldMetaBuilder<MyExample3288DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3288DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3288DTO_.customFieldId);
		fields.setEnabled(MyExample3288DTO_.customField);
		fields.setRequired(MyExample3288DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3288DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample3288DTO_.customField);
		}
		fields.enableFilter(MyExample3288DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}