package org.demo.documentation.feature.encryptsign.sign;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class Myexample3711MetaBuilder extends FieldMetaBuilder<Myexample3711DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3711DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(Myexample3711DTO_.fileSignId);
		fields.setEnabled(Myexample3711DTO_.fileSign);
		fields.setEnabled(Myexample3711DTO_.fileId);
		fields.setEnabled(Myexample3711DTO_.file);
		fields.setEnabled(
				Myexample3711DTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3711DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(Myexample3711DTO_.fileSign);
		fields.enableFilter(Myexample3711DTO_.file);
		fields.enableFilter(
				Myexample3711DTO_.id
		);
		fields.enableSort(
				Myexample3711DTO_.id
		);
	}

}
