package org.demo.documentation.fields.picktree.placeholder;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample3287Meta extends FieldMetaBuilder<MyExample3287DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3287DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3287DTO_.customFieldId);
		fields.setEnabled(MyExample3287DTO_.customField);
		fields.setPlaceholder(MyExample3287DTO_.customField, "Placeholder text");
		fields.setPlaceholder(MyExample3287DTO_.customFieldRO, "Placeholder text");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3287DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample3287DTO_.customField);
		}
		fields.enableFilter(MyExample3287DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}