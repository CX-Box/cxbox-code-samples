package org.demo.documentation.additional.signunsavedrecord;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample1348Meta extends FieldMetaBuilder<MyExample1348DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample1348DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample1348DTO_.file,
				MyExample1348DTO_.fileId,
				MyExample1348DTO_.fileSign,
				MyExample1348DTO_.fileSignId,
				MyExample1348DTO_.fileEncrypt,
				MyExample1348DTO_.fileEncryptId,
				MyExample1348DTO_.notes
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample1348DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		// no independent meta
	}

}
