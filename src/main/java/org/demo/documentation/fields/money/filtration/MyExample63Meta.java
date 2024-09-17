package org.demo.documentation.fields.money.filtration;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample63Meta extends FieldMetaBuilder<MyExample63DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample63DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample63DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample63DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample63DTO_.customField);
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample63DTO_.customField);
		}
		fields.enableSort(MyExample63DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]


}