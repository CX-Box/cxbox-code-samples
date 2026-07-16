package org.demo.documentation.feature.encryptsign.signencrypt;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.feature.encryptsign.signencrypt.enums.StatusSignEncryptEnum;
import org.springframework.stereotype.Service;

@Service
public class Myexample3714MetaBuilder extends FieldMetaBuilder<Myexample3714DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3714DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnumValues(Myexample3714DTO_.status, StatusSignEncryptEnum.values());
		fields.setEnabled(Myexample3714DTO_.fileSignId);
		fields.setEnabled(Myexample3714DTO_.fileSign);
		fields.setEnabled(Myexample3714DTO_.fileEncryptId);
		fields.setEnabled(Myexample3714DTO_.fileEncrypt);
		fields.setEnabled(Myexample3714DTO_.fileEncryptAndSignId);
		fields.setEnabled(Myexample3714DTO_.fileEncryptAndSign);
		fields.setEnabled(Myexample3714DTO_.fileId);
		fields.setEnabled(Myexample3714DTO_.file);

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3714DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.setEnumFilterValues(fields, Myexample3714DTO_.status, StatusSignEncryptEnum.values());
		fields.enableFilter(Myexample3714DTO_.status);
		fields.enableFilter(Myexample3714DTO_.fileSign);
		fields.enableFilter(Myexample3714DTO_.fileEncrypt);
		fields.enableFilter(Myexample3714DTO_.fileEncryptAndSign);
		fields.enableFilter(Myexample3714DTO_.file);
	}

}
