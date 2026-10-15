package org.demo.documentation.feature.encryptsign.largefile;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class Myexample10000MetaBuilder extends FieldMetaBuilder<Myexample10000DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample10000DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(Myexample10000DTO_.description);
		fields.setEnabled(Myexample10000DTO_.fileId);
		fields.setEnabled(Myexample10000DTO_.file);
		fields.setEnabled(Myexample10000DTO_.fileSignId);
		fields.setEnabled(Myexample10000DTO_.fileSign);
		fields.setEnabled(Myexample10000DTO_.fileEncryptId);
		fields.setEnabled(Myexample10000DTO_.fileEncrypt);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample10000DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(Myexample10000DTO_.description);
		fields.enableFilter(Myexample10000DTO_.file);
	}

}
