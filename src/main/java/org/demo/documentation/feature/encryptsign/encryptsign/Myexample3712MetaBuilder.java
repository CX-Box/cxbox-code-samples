package org.demo.documentation.feature.encryptsign.encryptsign;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class Myexample3712MetaBuilder extends FieldMetaBuilder<Myexample3712DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3712DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(Myexample3712DTO_.fileSignId);
		fields.setEnabled(Myexample3712DTO_.fileSign);
		fields.setEnabled(Myexample3712DTO_.fileEncryptId);
		fields.setEnabled(Myexample3712DTO_.fileEncrypt);
		fields.setEnabled(Myexample3712DTO_.fileEncryptAndSignId);
		fields.setEnabled(Myexample3712DTO_.fileEncryptAndSign);
		fields.setEnabled(Myexample3712DTO_.fileId);
		fields.setEnabled(Myexample3712DTO_.file);
		fields.setEnabled(
				Myexample3712DTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3712DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(Myexample3712DTO_.fileSign);
		fields.enableFilter(Myexample3712DTO_.fileEncrypt);
		fields.enableFilter(Myexample3712DTO_.fileEncryptAndSign);
		fields.enableFilter(Myexample3712DTO_.file);
		fields.enableFilter(
				Myexample3712DTO_.id
		);
		fields.enableSort(
				Myexample3712DTO_.id
		);
	}

}
