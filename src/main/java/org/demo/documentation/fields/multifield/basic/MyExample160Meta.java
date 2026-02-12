package org.demo.documentation.fields.multifield.basic;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample160Meta extends FieldMetaBuilder<MyExample160DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample160DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample160DTO_.customFieldAdditionalMulti);
		fields.setEnabled(MyExample160DTO_.customFieldMulti);
		fields.setEnabled(MyExample160DTO_.informationField);
		fields.setEnabled(MyExample160DTO_.customFieldAdditional);
		fields.setEnabled(MyExample160DTO_.customField);
		fields.setEnabled(MyExample160DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample160DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample160DTO_.customField);
		}
		fields.enableFilter(MyExample160DTO_.customFieldAdditionalMulti);
		fields.enableFilter(MyExample160DTO_.customFieldMulti);
		fields.enableFilter(MyExample160DTO_.informationField);
		fields.enableFilter(MyExample160DTO_.customFieldAdditional);
		fields.enableFilter(MyExample160DTO_.customField);
		fields.enableFilter(MyExample160DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}