package org.demo.documentation.fields.time.baselocaltime;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3512Meta extends FieldMetaBuilder<MyExample3512DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3512DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3512DTO_.customFieldhmm);
		fields.setEnabled(MyExample3512DTO_.customFieldh);
		fields.setEnabled(MyExample3512DTO_.customFieldhmmssA);
		fields.setEnabled(MyExample3512DTO_.customFieldhmmA);
		fields.setEnabled(MyExample3512DTO_.customFieldhA);
		fields.setEnabled(MyExample3512DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3512DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3512DTO_.customFieldhmm);
		fields.enableFilter(MyExample3512DTO_.customFieldh);
		fields.enableFilter(MyExample3512DTO_.customFieldhmmssA);
		fields.enableFilter(MyExample3512DTO_.customFieldhmmA);
		fields.enableFilter(MyExample3512DTO_.customFieldhA);
	}

}