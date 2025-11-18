package org.demo.documentation.fields.dictionary.filtration;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.fields.dictionary.filtration.enums.CustomFieldEnum;
import org.demo.documentation.fields.dictionary.filtration.enums.CustomFieldNewEnum;
import org.demo.documentation.fields.dictionary.filtration.enums.CustomFieldSecondEnum;
import org.springframework.stereotype.Service;
import java.util.List;

import static org.demo.documentation.fields.dictionary.filtration.enums.CustomFieldSecondEnum.*;

@Service
@RequiredArgsConstructor
public class MyExample87Meta extends FieldMetaBuilder<MyExample87DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample87DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnumValues(MyExample87DTO_.customFieldSecond, MIDDLE, LOW,HIGH);
		fields.setEnumValues(MyExample87DTO_.customField, CustomFieldEnum.values());
		fields.setEnumValues(MyExample87DTO_.customFieldNew, CustomFieldNewEnum.values());

		fields.setEnabled(MyExample87DTO_.customFieldSecond);
		fields.setEnabled(MyExample87DTO_.customField);
		fields.setEnabled(MyExample87DTO_.customFieldNew);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample87DTO> fields, InnerBcDescription bcDescription, Long parentId) {

		fields.setEnumFilterValues(fields, MyExample87DTO_.customFieldSecond, LOW,HIGH,MIDDLE);
		fields.enableFilter(MyExample87DTO_.customFieldSecond);
		if (Boolean.TRUE.equals(configuration.getForceActiveEnabled())) {
			fields.setForceActive(MyExample87DTO_.customField);
		}

		fields.setEnumFilterValues(fields, MyExample87DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample87DTO_.customField);
		fields.enableSort(MyExample87DTO_.customField);

		fields.setEnumFilterValues(fields, MyExample87DTO_.customFieldNew, CustomFieldNewEnum.values());
		fields.enableFilter(MyExample87DTO_.customFieldNew);
	}
	// --8<-- [end:buildIndependentMeta]
}