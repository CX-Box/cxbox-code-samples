package org.demo.documentation.other.postAction;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyExample6500PostActionExportToExcelListMeta extends FieldMetaBuilder<MyExample6500PostActionExportToExcelListDTO> {

	@Override
	public void buildRowDependentMeta(final RowDependentFieldsMeta<MyExample6500PostActionExportToExcelListDTO> fields, final InnerBcDescription bcDescription,
                                      final Long id,
                                      final Long parentId) {

	}

	@Override
	public void buildIndependentMeta(final FieldsMeta<MyExample6500PostActionExportToExcelListDTO> fields, final InnerBcDescription bcDescription, final Long parentId) {

	}

}
