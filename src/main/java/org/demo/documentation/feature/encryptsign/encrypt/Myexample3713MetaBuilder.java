package org.demo.documentation.feature.encryptsign.encrypt;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.feature.encryptsign.encrypt.enums.StatusEncryptEnum;
import org.springframework.stereotype.Service;

@Service
public class Myexample3713MetaBuilder extends FieldMetaBuilder<Myexample3713DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3713DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnumValues(Myexample3713DTO_.status, StatusEncryptEnum.values());
		fields.setEnabled(Myexample3713DTO_.fileEncryptId);
		fields.setEnabled(Myexample3713DTO_.fileEncrypt);
		fields.setEnabled(Myexample3713DTO_.fileId);
		fields.setEnabled(Myexample3713DTO_.file);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3713DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.setEnumFilterValues(fields, Myexample3713DTO_.status, StatusEncryptEnum.values());
		fields.enableFilter(Myexample3713DTO_.status);
		fields.enableFilter(Myexample3713DTO_.fileEncrypt);
		fields.enableFilter(Myexample3713DTO_.file);
	}

}
