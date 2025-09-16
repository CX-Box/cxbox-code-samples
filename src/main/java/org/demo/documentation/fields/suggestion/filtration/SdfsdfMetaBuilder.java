package org.demo.documentation.fields.suggestion.filtration;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class SdfsdfMetaBuilder extends AnySourceFieldMetaBuilder<SdfsdfDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<SdfsdfDTO> fields, BcDescription bcDescription, String id,
                                      String parentId) {
		fields.setEnabled(
			org.demo.documentation.fields.suggestion.filtration.SdfsdfDTO_.id
    );
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<SdfsdfDTO> fields, BcDescription bcDescription, String parentId) {
		fields.enableFilter(
			org.demo.documentation.fields.suggestion.filtration.SdfsdfDTO_.id);
		fields.enableSort(
			org.demo.documentation.fields.suggestion.filtration.SdfsdfDTO_.id);
  }

}
