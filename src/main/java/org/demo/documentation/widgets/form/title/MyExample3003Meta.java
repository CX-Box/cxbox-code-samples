package org.demo.documentation.widgets.form.title;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample3003Meta extends FieldMetaBuilder<MyExample3003DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3003DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3003DTO_.customField);
		fields.setEnabled(MyExample3003DTO_.customTitleField);
		fields.setEnabled(MyExample3003DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3003DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3003DTO_.customField);
		fields.enableFilter(MyExample3003DTO_.customTitleField);
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample3003DTO_.customField);
		}
		fields.enableFilter(MyExample3003DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]

}